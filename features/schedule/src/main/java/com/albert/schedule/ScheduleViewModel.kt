package com.albert.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.albert.domain.usecase.session.GetSessionsUseCase
import com.albert.ui_core_compose.extension.toUiState
import com.albert.ui_core_compose.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSessionUseCase: GetSessionsUseCase
) : ViewModel() {
    val sessions = liveData {
        emit(UiState.loading())
        emit(getSessionUseCase().toUiState())
    }
}