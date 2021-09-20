package com.albert.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.albert.shared.model.Session
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val session: Session = savedStateHandle.get("session")!!
}