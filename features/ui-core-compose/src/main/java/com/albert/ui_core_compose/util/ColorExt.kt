package com.albert.ui_core_compose.util

import androidx.compose.ui.graphics.Color
import com.albert.shared.HexColor

val String.toColor: Color
    get() = Color(android.graphics.Color.parseColor(this))

val HexColor.toColor: Color
    get() = this.value.toColor