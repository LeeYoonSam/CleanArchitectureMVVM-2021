package com.albert.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class Contributor(
    val name: String,
    val profileUrl: String
)
