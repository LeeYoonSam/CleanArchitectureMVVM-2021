package com.albert.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.albert.core_ui_compose.util.toColor

@Composable
internal fun DetailAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onNavigationClick: () -> Unit = {},
    onSharedClick: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                color = "#2F2E32".toColor()
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        },
        actions = {

        },
        modifier = modifier.fillMaxWidth(),
        backgroundColor = Color.White
    )
}