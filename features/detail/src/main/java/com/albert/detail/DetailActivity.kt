package com.albert.detail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.albert.ui.core.startActivity
import com.albert.ui_core_compose.setThemeContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
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
                DetailScreen(Modifier.padding(contentPadding))
            }
        }
    }

    companion object {
        fun start(context: Context, sessionId: Int) {
            context.startActivity<DetailActivity>(
                "sessionId" to sessionId
            )
        }
    }
}

@Preview
@Composable
fun previewDetail() {
    Scaffold(
        topBar = {
            DetailAppBar(
                title = "세션 소개",
                onNavigationClick = {  },
                onSharedClick = { /** TBD */ }
            )
        }
    ) { contentPadding ->
        DetailScreen(Modifier.padding(contentPadding))
    }
}