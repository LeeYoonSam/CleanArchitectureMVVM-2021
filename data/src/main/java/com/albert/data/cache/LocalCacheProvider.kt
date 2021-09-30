package com.albert.data.cache

import com.albert.data.model.EventContainer
import com.albert.shared.di.AssetProvider
import com.albert.shared.model.Event
import com.albert.data.model.SessionContainer
import com.albert.data.model.SessionData
import com.albert.data.model.SponsorContainer
import com.albert.shared.model.Sponsor
import kotlinx.serialization.json.Json
import javax.inject.Inject

class LocalCacheProvider @Inject constructor(
    private val assetProvider: AssetProvider
) {

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    suspend fun getSessions(): List<SessionData> {
        return json.decodeFromString(
            SessionContainer.serializer(),
            assetProvider.getRawSessions().value
        ).sessions
    }

    suspend fun getEventHistory(): List<Event> {
        return json.decodeFromString(
            EventContainer.serializer(),
            assetProvider.getRawEventHistory().value
        ).events
    }

    suspend fun getSponsors(): List<Sponsor> {
        return json.decodeFromString(
            SponsorContainer.serializer(),
            assetProvider.getRawSponsors().value
        ).sponsors
    }

}