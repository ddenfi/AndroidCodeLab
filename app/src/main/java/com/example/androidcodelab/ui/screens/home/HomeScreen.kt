package com.example.androidcodelab.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidcodelab.ui.components.ChipModel
import com.example.androidcodelab.ui.components.DisasterFilterGroup
import com.example.androidcodelab.ui.screens.MainViewModel

@Composable
fun HomeRoute(
    viewModel: MainViewModel,
    toDetail: () -> Unit,
) {
    val chipState by viewModel.test.collectAsStateWithLifecycle()
    HomeScreen(
        chipState = chipState,
        onItemChipClick =  viewModel::onChipUpdate,
        toDetail = toDetail
    )
}
@Composable
internal fun HomeScreen(
    chipState: List<ChipModel>,
    onItemChipClick: (ChipModel) -> Unit,
    toDetail: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Home Screens", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        DisasterFilterGroup(chipState = chipState, onItemChipClick = onItemChipClick)
        Button(onClick = toDetail) {
            Text(text = "TO Detail")
        }
    }
}