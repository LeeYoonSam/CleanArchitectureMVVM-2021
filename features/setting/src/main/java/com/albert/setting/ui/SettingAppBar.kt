package com.albert.setting.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albert.core_ui_compose.util.toColor

@Composable
internal fun SettingAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null
) {
    AppBar(
        modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        if (navigationIcon != null) {
            Spacer(modifier = NavigationIconModifier)
            Row(
                modifier = modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CompositionLocalProvider(
                    LocalContentAlpha provides ContentAlpha.high,
                    content = navigationIcon
                )
            }
        } else {
            Spacer(modifier = AppBarHorizontalModifier)
        }

        Text(
            text = title,
            color = "#2F2E32".toColor(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = AppBarHorizontalModifier)
    }
    
    Surface(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Text(
            text = title,
            color = "#2F2E32".toColor(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}

@Composable
private fun AppBar(
    modifier: Modifier = Modifier,
    elevation: Dp,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        modifier = modifier,
        elevation = elevation
    ) {
        Row(
            modifier = Modifier.height(78.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

private val NavigationIconModifier = Modifier.width(4.dp)
private val AppBarHorizontalModifier = Modifier.width(24.dp)