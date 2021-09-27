package com.albert.shared.di

import com.albert.shared.JsonRawString

interface AssetProvider {
    suspend fun getRawSessions(): JsonRawString
    suspend fun getRawEventHistory(): JsonRawString
    suspend fun getRawSponsors(): JsonRawString
}