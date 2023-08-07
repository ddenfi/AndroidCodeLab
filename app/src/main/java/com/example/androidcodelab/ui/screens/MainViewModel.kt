package com.example.androidcodelab.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.androidcodelab.ui.components.ChipModel
import com.example.androidcodelab.ui.components.listDisaster
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel:ViewModel() {
    var chipState = MutableStateFlow(listDisaster)
        private set

    fun onChipUpdate(index:Int,isActive:Boolean){
        chipState.update {
            it[index].selected = isActive
            it
        }
        Log.d("CHIP",chipState.value[index].selected.toString())
    }
}