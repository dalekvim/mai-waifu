package com.example.datafrominternet.ui.fragments

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalUriHandler
import com.example.datafrominternet.ui.screens.WaifuUiState
import com.example.datafrominternet.ui.screens.WaifuViewModel


@Composable
fun ActionMenuState(waifuViewModel: WaifuViewModel) {

    when (val waifuUiState = waifuViewModel.waifuUiState) {
        is WaifuUiState.Loading -> {
            ActionMenu()
        }

        is WaifuUiState.Success -> {
            val image = waifuUiState.waifuImages.images[0]
            ActionMenu(url = image.url, source = image.source)
        }

        is WaifuUiState.Error -> {
            ActionMenu(newImage = waifuViewModel::getWaifuImage)
        }
    }
}

@Composable
fun ActionMenu(url: String? = null, source: String? = null, newImage: (() -> Unit)? = null) {

    Box {
        var expanded by remember { mutableStateOf(false) }

        IconButton(onClick = {
            if (url != null || source != null) expanded = true
            newImage?.invoke()
        }) {
            Icon(
                Icons.Default.MoreVert,
                contentDescription = "Menu"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            val uriHandler = LocalUriHandler.current

            DropdownMenuItem(
                text = { Text(text = "Source") },
                onClick = {
                    if (source != null) {
                        uriHandler.openUri(source)
                    }
                }
            )
            DropdownMenuItem(
                text = { Text(text = "Raw") },
                onClick = {
                    if (url != null) {
                        uriHandler.openUri(url)
                    }
                }
            )
        }
    }
}