package com.albert.data.model

import com.albert.shared.Level
import com.albert.shared.Room
import com.albert.shared.Tag
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
    val level: Level,
    val tags: List<Tag> = emptyList(),
    val room: Room = Room.Etc,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
)