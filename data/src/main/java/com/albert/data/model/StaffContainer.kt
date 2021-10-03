package com.albert.data.model

import com.albert.shared.model.User
import kotlinx.serialization.Serializable

@Serializable
internal data class StaffContainer(
    val staff: List<User> = emptyList()
)