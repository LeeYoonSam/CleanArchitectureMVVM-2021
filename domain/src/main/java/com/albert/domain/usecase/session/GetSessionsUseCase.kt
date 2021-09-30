package com.albert.domain.usecase.session

import com.albert.data.ConferenceRepository
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.model.Session
import com.albert.shared.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSessionsUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : NonParamCoroutineUseCase<List<Session>>(dispatcher) {
    override suspend fun execute(): List<Session> {
        return conferenceRepository.getSessions()
            .map {
                Session(
                    title = it.title,
                    content = it.content,
                    speakers = it.speakers,
                    level = it.level,
                    tags = it.tags,
                    room = it.room,
                    startTime = it.startTime,
                    endTime = it.endTime
                )
            }
    }
}