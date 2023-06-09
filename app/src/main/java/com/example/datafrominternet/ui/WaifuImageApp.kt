package com.example.datafrominternet.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.datafrominternet.ui.fragments.WaifuSheetContentState
import com.example.datafrominternet.ui.fragments.WaifuTopAppBar
import com.example.datafrominternet.ui.screens.HomeScreen
import com.example.datafrominternet.ui.screens.TagViewModel
import com.example.datafrominternet.ui.screens.WaifuViewModel


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WaifuImageApp(
    tagViewModel: TagViewModel = viewModel()
) {
    val waifuViewModel: WaifuViewModel = viewModel(factory = WaifuViewModel.Factory)

//    var includedTags by rememberSaveable {
//        mutableStateOf(emptyList<Tags>())
//    }
//
//    val toggleIncludedTags = fun(tag: Tags) {
//        includedTags = if (tag in includedTags) {
//            includedTags.filter { it != tag }
//        } else {
//            includedTags + tag
//        }
//    }
//
//    val clearTags = fun() {
//        includedTags = emptyList()
//    }

    BottomSheetScaffold(
        topBar = {
            WaifuTopAppBar(
                waifuViewModel = waifuViewModel,
                includedTags = tagViewModel.includedTags,
                clearTags = {}
            )
        },
        sheetContent = {
            Surface(
                color = MaterialTheme.colorScheme.background,
                modifier = Modifier.fillMaxSize()
            ) {
                WaifuSheetContentState(
                    waifuViewModel = waifuViewModel,
                    includedTags = tagViewModel.includedTags,
                    toggleIncludedTags = tagViewModel::toggleIncludedTags,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    ) {
        Surface(
            color = MaterialTheme.colorScheme.surface,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            HomeScreen(
                waifuViewModel = waifuViewModel,
                includedTags = tagViewModel.includedTags,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
