package com.albert.data.repository

import com.albert.data.ConferenceApi
import com.albert.data.ConferenceRepository
import com.albert.data.api.GithubApi
import com.albert.data.cache.LocalCacheProvider
import com.albert.shared.model.Event
import com.albert.data.model.SessionData
import com.albert.shared.model.Sponsor
import com.albert.shared.model.User
import javax.inject.Inject

class ConferenceRepositoryImpl @Inject constructor(
    private val conferenceApi: ConferenceApi,
    private val githubApi: GithubApi,
    private val localCacheProvider: LocalCacheProvider
) : ConferenceRepository {
    override suspend fun getEventHistory(): List<Event> {
        return runCatching {
            conferenceApi.getEventHistory()
        }.getOrDefault(localCacheProvider.getEventHistory())
    }

    override suspend fun getSessions(): List<SessionData> {
        return runCatching {
            conferenceApi.getSessions()
        }.getOrDefault(localCacheProvider.getSessions())
    }

    override suspend fun getSponsors(): List<Sponsor> {
        return runCatching {
            conferenceApi.getSponsors()
        }.getOrDefault(localCacheProvider.getSponsors())
    }

    override suspend fun getStaffs(): List<User> {
        return runCatching {
            conferenceApi.getStaffs()
        }.getOrDefault(localCacheProvider.getStaffs())
    }

    override suspend fun getContributors(
        owner: String,
        name: String,
        pageNo: Int
    ): List<User> {
        return githubApi.getContributors(
            owner = owner,
            name = name,
            page = pageNo
        ).map {
            User(
                name = it.name,
                photoUrl = it.photoUrl
            )
        }
    }
}