package com.albert.schedule

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.albert.ui_core_compose.util.toColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScheduleScreen(
    onSessionClick: () -> Unit = { }
) {
    LazyColumn {
        items(20) {
            Session(onSessionClick = onSessionClick)
            Divider(
                modifier = Modifier.padding(horizontal = 24.dp),
                color = "#EFEFEF".toColor()
            )
        }
    }
}