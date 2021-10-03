package com.albert.architecture.provider

import android.content.Context
import com.albert.architecture.util.AssetUtil
import com.albert.shared.JsonRawString
import com.albert.shared.di.AssetProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CacheAssetLoader @Inject constructor(
    @ApplicationContext private val context: Context
): AssetProvider {
    override suspend fun getRawSessions(): JsonRawString {
        return getJsonRawString("sessions.json")
    }

    override suspend fun getRawEventHistory(): JsonRawString {
        return getJsonRawString("event.json")
    }

    override suspend fun getRawSponsors(): JsonRawString {
        return getJsonRawString("sponsor.json")
    }

    override suspend fun getRawStaffs(): JsonRawString {
        return getJsonRawString("staff.json")
    }

    private fun getJsonRawString(fileName: String): JsonRawString {
        return JsonRawString(AssetUtil.loadAsset(context, fileName))
    }
}