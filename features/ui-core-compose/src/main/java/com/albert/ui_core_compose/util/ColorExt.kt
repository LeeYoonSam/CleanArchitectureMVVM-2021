package com.albert.ui_core_compose.util

import androidx.compose.ui.graphics.Color
import com.albert.shared.HexColor

fun String.toColor(): Color =
    Color(android.graphics.Color.parseColor(this))

fun HexColor.toColor(): Color =
    this.value.toColor()