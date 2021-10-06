package com.albert.detail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.albert.detail.util.map
import com.albert.shared.ext.decodeFromString
import com.albert.shared.ext.encodeToString
import com.albert.shared.model.Session
import com.albert.core.ui.extraNotNull
import com.albert.core.ui.startActivity
import com.albert.core_ui_compose.setThemeContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {

    private val session by extraNotNull<String>("session")
        .map { encodeString ->
            encodeString.decodeFromString<Session>()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setThemeContent {
            Scaffold(
                topBar = {
                    DetailAppBar(
                        title = "세션 소개",
                        onNavigationClick = { onBackPressed() },
                        onSharedClick = { /** TBD */ }
                    )
                }
            ) { contentPadding ->
                DetailScreen(
                    session = session,
                    modifier = Modifier.padding(contentPadding)
                )
            }
        }
    }

    companion object {
        fun start(context: Context, session: Session) {
            context.startActivity<DetailActivity>(
                "session" to session.encodeToString()
            )
        }
    }
}