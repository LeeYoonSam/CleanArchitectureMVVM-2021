package com.albert.home.model

import com.albert.shared.model.Event
import com.albert.shared.model.Sponsor

class HomeInfo(
    val sponsors: List<Sponsor>,
    val events: List<Event>
)