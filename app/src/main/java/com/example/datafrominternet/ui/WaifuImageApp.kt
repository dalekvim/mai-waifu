package com.example.datafrominternet.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datafrominternet.R
import com.example.datafrominternet.ui.screens.HomeScreen
import com.example.datafrominternet.ui.screens.WaifuViewModel

@Composable
fun WaifuImageApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val waifuViewModel: WaifuViewModel = viewModel(factory = WaifuViewModel.Factory)

                HomeScreen(
                    waifuUiState = waifuViewModel.waifuUiState,
                    newImage = waifuViewModel::getWaifuImage
                )
            }
        }
    }
}