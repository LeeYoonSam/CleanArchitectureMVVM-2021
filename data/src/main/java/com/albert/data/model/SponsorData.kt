package com.albert.data.model

import com.albert.shared.model.Sponsor
import kotlinx.serialization.Serializable

@Serializable
internal data class SponsorContainer(
    val sponsors: List<Sponsor> = emptyList()
)