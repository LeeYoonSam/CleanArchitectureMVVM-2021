package com.albert.domain.usecase.contributor

import com.albert.data.ConferenceRepository
import com.albert.domain.UseCase
import com.albert.shared.IoDispatcher
import com.albert.shared.model.User
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetContributorsUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : UseCase<GetContributorsUseCase.Param, List<User>>(dispatcher) {

    override suspend fun execute(param: Param): List<User> {
        return conferenceRepository.getContributors(
            owner = param.owner,
            name = param.name,
            pageNo = param.pageNo
        )
    }

    data class Param(
        val owner: String,
        val name: String,
        val pageNo: Int
    )
}