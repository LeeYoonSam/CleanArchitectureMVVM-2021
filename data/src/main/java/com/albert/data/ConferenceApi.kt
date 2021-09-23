package com.albert.data

import com.albert.shared.model.Event
import com.albert.shared.model.Session
import com.albert.shared.model.Sponsor
import retrofit2.http.GET

interface ConferenceApi {
    @GET("/session.json")
    suspend fun getSessions(): List<Session>

    @GET("/event.json")
    suspend fun getEventHistory(): List<Event>

    @GET("/sponsor.json")
    suspend fun getSponsors(): List<Sponsor>
}