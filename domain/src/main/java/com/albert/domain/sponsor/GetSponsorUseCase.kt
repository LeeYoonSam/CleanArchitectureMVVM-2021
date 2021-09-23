package com.albert.domain.sponsor

import com.albert.data.ConferenceApi
import com.albert.domain.NonParamCoroutineUseCase
import com.albert.shared.IoDispatcher
import com.albert.shared.model.Sponsor
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSponsorUseCase @Inject constructor(
    private val conferenceApi: ConferenceApi,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Sponsor>>(ioDispatcher) {
    override suspend fun execute(): List<Sponsor> {
        return runCatching {
            conferenceApi.getSponsors()
        }.getOrNull() ?: sample()
    }

    private fun sample(): List<Sponsor> {
        return listOf(
            Sponsor(
                name = "toss",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_toss.png",
                homepage = "https://toss.im/"
            ),
            Sponsor(
                name = "헤이딜러",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_heydealer.png",
                homepage = "https://dealer.heydealer.com/"
            ),
            Sponsor(
                name = "카카오페이",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_kakaopay.png",
                homepage = "https://www.kakaopay.com/"
            ),
            Sponsor(
                name = "VCNC",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_vcnc.png",
                homepage = "https://tadacareer.vcnc.co.kr/"
            )
        )
    }

}