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
        return AssetUtil.loadAsset(context, "sessions.json")
    }

    override suspend fun getRawEventHistory(): JsonRawString {
        return AssetUtil.loadAsset(context, "event.json")
    }

    override suspend fun getRawSponsors(): JsonRawString {
        return AssetUtil.loadAsset(context, "sponsor.json")

    }
}