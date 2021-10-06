package com.albert.core_ui_compose.extension

import com.albert.shared.result.Result
import com.albert.core_ui_compose.state.UiState

fun <T> Result<T>.toUiState(): UiState<T> {
    return when (this) {
        is Result.Error -> UiState(exception = this.exception)
        Result.Loading -> UiState.loading()
        is Result.Success -> UiState.success(value = this.data)
    }
}