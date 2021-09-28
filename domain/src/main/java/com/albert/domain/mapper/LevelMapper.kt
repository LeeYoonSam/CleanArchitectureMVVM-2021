package com.albert.domain.mapper

import com.albert.shared.HexColor
import com.albert.shared.model.Level

internal fun String.toLevel(): Level {
    val color = when (this) {
        "심화" -> "#897DAD"
        "중급" -> "#E59B86"
        else -> "#ABC192"
    }
    return Level(this, HexColor(color))
}