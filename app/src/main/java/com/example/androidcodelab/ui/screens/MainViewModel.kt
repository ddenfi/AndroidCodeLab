package com.example.androidcodelab.ui.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidcodelab.R
import com.example.androidcodelab.ui.components.ChipModel
import com.example.androidcodelab.ui.components.listDisaster
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val listChip = MutableStateFlow(listDisaster)

    val listChipActive: SnapshotStateList<String> = mutableStateListOf()

    var chipActive =
        MutableSharedFlow<SnapshotStateList<String>>(replay = 1, extraBufferCapacity = 1)

    var test = combine(listChip, chipActive) { listChip, chipActive ->
        val temp = listChip.map {
            ChipModel(title = it.title, selected = chipActive.contains(it.title), icon = it.icon)
        }
        temp
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), listChip.value.toList())

    fun onChipUpdate(item: ChipModel) {
        if (listChipActive.contains(item.title)) {
            listChipActive.remove(item.title)
        } else {
            listChipActive.add(item.title)
        }
        viewModelScope.launch {
            chipActive.emit(listChipActive)
        }
        Log.d("Chip", listChipActive.toList().toString())
    }
}