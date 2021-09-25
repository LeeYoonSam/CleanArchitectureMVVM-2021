package com.albert.domain.session

import com.albert.data.ConferenceRepository
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.model.Session
import com.albert.shared.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSessionsUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Session>>(dispatcher) {
    override suspend fun execute(): List<Session> {
        return conferenceRepository.getSessions()
    }
}