package com.example.datafrominternet.ui.fragments

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.datafrominternet.R
import com.example.datafrominternet.ui.screens.WaifuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaifuTopAppBar(waifuViewModel: WaifuViewModel) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = { ActionMenuState(waifuViewModel = waifuViewModel) }
    )
}