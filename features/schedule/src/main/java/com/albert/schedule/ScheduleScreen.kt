package com.albert.schedule

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.albert.ui_core_compose.util.toColor

@Composable
fun ScheduleScreen() {
    LazyColumn {
        item(20) {
            Session()
            Divider(
                modifier = Modifier.padding(horizontal = 24.dp),
                color = "#EFEFEF".toColor()
            )
        }
    }
}