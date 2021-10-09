package com.albert.setting.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import com.albert.core.ui.startActivity
import com.albert.setting.Route
import com.albert.setting.ScreenAction
import com.albert.core_ui_compose.setThemeContent
import com.albert.setting.ui.detail.SettingDetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            val context = LocalContext.current

            SettingScreen { action ->
                val route = when (action) {
                    ScreenAction.Speaker -> Route.Speaker
                    ScreenAction.Contributor -> Route.Contributor
                    ScreenAction.Staff -> Route.Staff
                }

                context.startActivity<SettingDetailActivity>(
                    "type" to route
                )
            }
        }
    }
}

