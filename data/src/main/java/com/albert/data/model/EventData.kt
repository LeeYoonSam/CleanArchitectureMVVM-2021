package com.albert.data.model

import com.albert.shared.model.Event
import kotlinx.serialization.Serializable

@Serializable
internal data class EventContainer(
    val events: List<Event> = emptyList()
)