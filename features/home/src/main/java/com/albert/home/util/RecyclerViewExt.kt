package com.albert.home.util

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.clearItemDecoration() {
    repeat(itemDecorationCount) {
        removeItemDecorationAt(0)
    }
}