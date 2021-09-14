package com.albert.ui_core_compose.util

import androidx.compose.ui.graphics.Color

fun String.toColor(): Color =
    Color(android.graphics.Color.parseColor(this))
