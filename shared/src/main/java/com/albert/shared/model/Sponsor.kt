package com.albert.shared.model

import kotlinx.serialization.Serializable

@Serializable
data class Sponsor(
    val name: String,
    val photoUrl: String,
    val homepage: String
)