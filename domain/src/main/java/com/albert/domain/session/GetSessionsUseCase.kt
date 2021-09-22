package com.albert.domain.session

import com.albert.data.ConferenceApi
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.model.Session
import com.albert.shared.model.Level
import com.albert.shared.model.Speaker
import com.albert.shared.model.Tag
import com.albert.shared.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import kotlin.random.Random

class GetSessionsUseCase @Inject constructor(
    private val conferenceApi: ConferenceApi,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Session>>(dispatcher) {
    override suspend fun execute(): List<Session> {
        return runCatching {
            conferenceApi.getSessions()
        }.getOrNull() ?: sample()
    }

    private fun sample(): List<Session> {
        val random = Random(System.currentTimeMillis())
        return mutableListOf<Session>().apply {
            repeat(20) {
                add(
                    Session(
                        title = "Session Title $it",
                        content = "Content $it",
                        speakers = listOf(
                            Speaker(
                                name = "발표자 $it",
                                photoUrl = ""
                            )
                        ),
                        level = Level("중급", color = "#E59B86"),
                        tags = listOf(
                            Tag(title = "Tag ${random.nextInt(10)}", color = "#897dad"),
                            Tag(title = "Tag ${random.nextInt(10)}", color = "#92b9e9")
                        ),
                        room = "Track1",
                        startTime = "2021-09-25T14:00:00.000Z"
                            .toInstant()
                            .toLocalDateTime(TimeZone.of("Asia/Seoul")),
                        endTime = "2021-09-25T14:30:00.000Z"
                            .toInstant()
                            .toLocalDateTime(TimeZone.of("Asia/Seoul"))
                    )
                )
            }
        }
    }
}