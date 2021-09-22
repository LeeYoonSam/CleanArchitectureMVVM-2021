package com.albert.data

import com.albert.shared.model.Session
import retrofit2.http.GET

interface ConferenceApi {
    @GET("/session.json")
    suspend fun getSessions(): List<Session>
}