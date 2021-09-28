package com.albert.data

import com.albert.shared.model.Event
import com.albert.data.model.SessionData
import com.albert.shared.model.Sponsor

interface ConferenceRepository {
    suspend fun getEventHistory(): List<Event>
    suspend fun getSessions(): List<SessionData>
    suspend fun getSponsors(): List<Sponsor>
}