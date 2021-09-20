package com.albert.detail.navigation

import android.content.Context
import com.albert.detail.DetailActivity
import com.albert.navigator.DetailNavigator
import com.albert.shared.model.Session
import javax.inject.Inject

class DetailNavigatorImpl @Inject constructor(): DetailNavigator {
    override fun openDetail(context: Context, session: Session) {
        DetailActivity.start(context, session)
    }
}