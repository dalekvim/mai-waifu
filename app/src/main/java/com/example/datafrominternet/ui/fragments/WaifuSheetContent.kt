package com.example.datafrominternet.ui.fragments

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.datafrominternet.R
import com.example.datafrominternet.model.Waifu
import com.example.datafrominternet.ui.screens.Tags
import com.example.datafrominternet.ui.screens.WaifuUiState
import com.example.datafrominternet.ui.screens.WaifuViewModel
import com.example.datafrominternet.ui.screens.stringToTag

@Composable
fun WaifuSheetContentState(
    waifuViewModel: WaifuViewModel,
    includedTags: List<Tags>,
    toggleIncludedTags: (tag: Tags) -> Unit,
    modifier: Modifier
) {
    when (val waifuUiState = waifuViewModel.waifuUiState) {

        is WaifuUiState.Loading -> {}

        is WaifuUiState.Success -> {
            val image = waifuUiState.waifuImages.images[0]

            WaifuSheetContent(
                image = image,
                includedTags = includedTags,
                toggleIncludedTags = toggleIncludedTags,
                modifier = modifier
            )
        }

        is WaifuUiState.Error -> {
            Text(text = stringResource(R.string.error_help))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WaifuSheetContent(
    image: Waifu,
    includedTags: List<Tags>?,
    toggleIncludedTags: (tag: Tags) -> Unit,
    modifier: Modifier
) {
    val scrollState = rememberScrollState()
    Row(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollState)
    ) {
        if (image.tags != null) {
            image.tags.forEach {
                FilterChip(
                    label = { Text(text = it.name) },
                    selected = if (includedTags != null) (stringToTag(it.name) in includedTags) else false,
                    onClick = { toggleIncludedTags(stringToTag(it.name)) },
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}