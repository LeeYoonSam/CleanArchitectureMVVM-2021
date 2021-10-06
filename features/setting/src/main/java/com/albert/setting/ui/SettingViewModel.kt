package com.albert.setting.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.albert.domain.usecase.contributor.GetContributorsUseCase
import com.albert.domain.usecase.session.GetSessionsUseCase
import com.albert.domain.usecase.staff.GetStaffUseCase
import com.albert.shared.result.data
import com.albert.core_ui_compose.extension.toUiState
import com.albert.core_ui_compose.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase,
    private val getStaffUseCase: GetStaffUseCase,
    private val getContributorsUseCase: GetContributorsUseCase
) : ViewModel() {
    val speakers = liveData {
        emit(UiState.loading())
        val users = getSessionsUseCase().data.orEmpty()
            .flatMap {
                it.speakers
            }.distinct()
            .sortedBy { it.name }
        emit(UiState.success(users))
    }

    val staff = liveData {
        emit(UiState.loading())
        emit(getStaffUseCase().toUiState())
    }

    val contributors = liveData {
        emit(UiState.loading())
        val users = getContributorsUseCase(
            GetContributorsUseCase.Param(
                "LeeYoonSam",
                "CleanArchitectureMVVM-2021",
                1
            )
        ).data.orEmpty()
        emit(UiState.success(users))
    }
}