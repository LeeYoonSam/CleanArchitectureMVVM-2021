package com.albert.domain.usecase.event

import com.albert.data.ConferenceRepository
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.IoDispatcher
import com.albert.shared.model.Event
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetEventHistoryUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Event>>(dispatcher) {
    override suspend fun execute(): List<Event> {
        return conferenceRepository.getEventHistory()
    }
}