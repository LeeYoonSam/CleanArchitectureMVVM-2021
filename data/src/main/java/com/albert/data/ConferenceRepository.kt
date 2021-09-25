package com.albert.data

import com.albert.shared.model.Event
import com.albert.shared.model.Session
import com.albert.shared.model.Sponsor

interface ConferenceRepository {
    suspend fun getEventHistory(): List<Event>
    suspend fun getSessions(): List<Session>
    suspend fun getSponsors(): List<Sponsor>
}