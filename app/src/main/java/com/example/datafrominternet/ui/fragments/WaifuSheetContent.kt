package com.example.datafrominternet.ui.fragments

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.datafrominternet.R
import com.example.datafrominternet.model.Waifu
import com.example.datafrominternet.ui.screens.WaifuUiState
import com.example.datafrominternet.ui.screens.WaifuViewModel

@Composable
fun WaifuSheetContentState(
    waifuViewModel: WaifuViewModel,
    modifier: Modifier
) {

    when (val waifuUiState = waifuViewModel.waifuUiState) {

        is WaifuUiState.Loading -> {}

        is WaifuUiState.Success -> {
            val image = waifuUiState.waifuImages.images[0]

            WaifuSheetContent(
                image = image,
                modifier = modifier
            )
        }

        is WaifuUiState.Error -> {
            Text(text = stringResource(R.string.error_help))
        }
    }
}

@Composable
fun WaifuSheetContent(
    image: Waifu,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        if (image.tags != null) {
            for (tag in image.tags) {
                Button(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = tag.name)
                }
            }
        }
    }

}