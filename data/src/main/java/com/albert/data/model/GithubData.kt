package com.albert.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GithubContributors(
    @SerialName("login") val name: String,
    @SerialName("avatar_url") val photoUrl: String
)