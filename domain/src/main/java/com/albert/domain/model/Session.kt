package com.albert.domain.model

import com.albert.shared.HexColor
import com.albert.shared.SessionId
import kotlinx.datetime.LocalDateTime

data class Session(
    val sessionId: SessionId,

    val title: String,
    val content: String,
    val speakers: List<Speaker>,
    val level: Level,
    val tags: List<Tag>,

    val room: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)

data class Level(
    val title: String,
    val color: HexColor
)

data class Tag(
    val title: String,
    val color: HexColor
)

data class Speaker(
    val name: String,
    val photoUrl: String
)