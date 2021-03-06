package com.albert.setting.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.albert.core.ui.extraNotNull
import com.albert.core_ui_compose.setThemeContent
import com.albert.setting.Route
import com.albert.setting.ui.NavigationContainer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingDetailActivity : AppCompatActivity() {
    private val type by extraNotNull<Route>("type")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeContent {
            NavigationContainer(
                type = type,
                onBackAction = { onBackPressed() }
            )
        }
    }
}