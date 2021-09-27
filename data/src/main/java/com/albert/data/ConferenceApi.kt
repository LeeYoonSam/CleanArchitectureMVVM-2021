package com.albert.data

import com.albert.shared.model.Event
import com.albert.shared.model.Session
import com.albert.shared.model.SessionData
import com.albert.shared.model.Sponsor
import retrofit2.http.GET

interface ConferenceApi {
    @GET("/LeeYoonSam/CleanArchitectureMVVM-2021/main/app/src/main/assets/sessions.json")
    suspend fun getSessions(): List<SessionData>

    @GET("/LeeYoonSam/CleanArchitectureMVVM-2021/main/app/src/main/assets/event.json")
    suspend fun getEventHistory(): List<Event>

    @GET("/LeeYoonSam/CleanArchitectureMVVM-2021/main/app/src/main/assets/sponsor.json")
    suspend fun getSponsors(): List<Sponsor>
}