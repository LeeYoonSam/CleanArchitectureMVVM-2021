package com.albert.data.model

import com.albert.shared.model.Speaker
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class SessionContainer(
    val sessions: List<SessionData> = emptyList()
)

@Serializable
data class SessionData(
    val title: String,
    val content: List<String>,
    val speakers: List<Speaker>,
    val level: String,
    val tags: List<String> = emptyList(),
    val room: String?,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
)