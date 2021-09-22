package com.albert.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.albert.domain.session.GetSessionsUseCase
import com.albert.shared.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSessionUseCase: GetSessionsUseCase
) : ViewModel() {
    val sessions = liveData {
        emit(Result.Loading)
        emit(getSessionUseCase())
    }
}