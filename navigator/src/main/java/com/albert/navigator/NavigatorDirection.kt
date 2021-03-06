package com.albert.navigator

import android.content.Context
import com.albert.shared.model.Session

interface DetailNavigator {
    /** 세션 상세 화면으로 이동 */
    fun openDetail(
        context: Context,
        session: Session
    )
}