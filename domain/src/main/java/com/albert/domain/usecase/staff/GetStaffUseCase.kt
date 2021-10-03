package com.albert.domain.usecase.staff

import com.albert.data.ConferenceRepository
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.IoDispatcher
import com.albert.shared.model.User
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetStaffUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : NonParamCoroutineUseCase<List<User>>(dispatcher) {

    override suspend fun execute(): List<User> {
        return conferenceRepository.getStaffs()
            .sortedBy { it.name }
    }
}