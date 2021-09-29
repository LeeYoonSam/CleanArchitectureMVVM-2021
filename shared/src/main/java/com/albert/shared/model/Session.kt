package com.albert.shared.model

import com.albert.shared.Level
import com.albert.shared.Tag
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val title: String,
    val content: List<String>,
    val speakers: List<Speaker>,
    val level: Level,
    val tags: List<Tag>,

    val room: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)

@Serializable
data class Speaker(
    val name: String,
    val photoUrl: String
)