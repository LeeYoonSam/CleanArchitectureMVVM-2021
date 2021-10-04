package com.albert.setting.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.albert.domain.usecase.staff.GetStaffUseCase
import com.albert.shared.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getStaffUseCase: GetStaffUseCase
) : ViewModel() {
    val staff = liveData {
        emit(Result.Loading)
        emit(getStaffUseCase())
    }
}