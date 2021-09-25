package com.albert.domain.sponsor

import com.albert.data.ConferenceRepository
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.IoDispatcher
import com.albert.shared.model.Sponsor
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSponsorUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Sponsor>>(ioDispatcher) {
    override suspend fun execute(): List<Sponsor> {
        return conferenceRepository.getSponsors()
    }
}