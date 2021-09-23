package com.albert.domain.event

import com.albert.data.ConferenceApi
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.IoDispatcher
import com.albert.shared.model.Event
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.datetime.toLocalDate
import javax.inject.Inject

class GetEventHistoryUseCase @Inject constructor(
    private val conferenceApi: ConferenceApi,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Event>>(dispatcher) {
    override suspend fun execute(): List<Event> {
        return runCatching {
            conferenceApi.getEventHistory()
        }.getOrNull() ?: sample()
    }

    private fun sample(): List<Event> {
        return listOf(
            Event(
                date = "2021-09-25".toLocalDate(),
                url = "/",
                isEndEvent = false
            ),
            Event(
                date = "2020-09-05".toLocalDate(),
                url = "https://droidknights.github.io/2020/"
            ),
            Event(
                date = "2019-04-05".toLocalDate(),
                url = "https://droidknights.github.io/2019/"
            ),
            Event(
                date = "2018-04-22".toLocalDate(),
                url = "https://droidknights.github.io/2018/"
            ),
            Event(
                date = "2017-03-25".toLocalDate(),
                url = "https://droidknights.github.io/2017/"
            ),
        )
    }
}