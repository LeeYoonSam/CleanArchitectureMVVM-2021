package com.albert.setting.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albert.setting.Route
import com.albert.setting.ScreenAction
import com.albert.core_ui_compose.layout.FullScreenLoading
import com.albert.core_ui_compose.layout.LoadingContent
import com.albert.core_ui_compose.setThemeContent
import com.albert.core_ui_compose.state.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            SettingContainer()
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun SettingContainer(
    viewModel: SettingViewModel = viewModel()
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Setting.destination) {
        composable(Route.Setting.destination) {
            SettingScreen { action ->
                val route = when (action) {
                    ScreenAction.Speaker -> Route.Speaker
                    ScreenAction.Contributor -> Route.Contributor
                    ScreenAction.Staff -> Route.Staff
                }
                navController.navigate(route.destination)
            }
        }

        composable(Route.Speaker.destination) {
            SpeakerContainer(
                viewModel = viewModel,
                onBackAction = { navController.navigateUp() }
            )
        }

        composable(Route.Contributor.destination) {
            ContributorContainer(
                viewModel = viewModel,
                onBackAction = { navController.navigateUp() }
            )
        }

        composable(Route.Staff.destination) {
            StaffContainer(
                viewModel = viewModel,
                onBackAction = { navController.navigateUp() }
            )
        }
    }
}

@Composable
private fun SpeakerContainer(
    viewModel: SettingViewModel = viewModel(),
    onBackAction: () -> Unit
) {
    val result by viewModel.speakers.observeAsState(UiState.loading())

    LoadingContent(
        loading = result.initialLoad,
        loadingContent = { FullScreenLoading()}
    ) {
        SpeakerScreen(
            speakers = result.getOrThrow(),
            onBackAction = onBackAction
        )
    }
}

@Composable
private fun ContributorContainer(
    viewModel: SettingViewModel = viewModel(),
    onBackAction: () -> Unit
) {
    val result by viewModel.contributors.observeAsState(UiState.loading())

    LoadingContent(
        loading = result.initialLoad,
        loadingContent = { FullScreenLoading()}
    ) {
        ContributorScreen(
            users = result.getOrThrow(),
            onBackAction = onBackAction
        )
    }
}

@Composable
private fun StaffContainer(
    viewModel: SettingViewModel = viewModel(),
    onBackAction: () -> Unit
) {
    val result by viewModel.staff.observeAsState(UiState.loading())

    LoadingContent(
        loading = result.initialLoad,
        loadingContent = { FullScreenLoading()}
    ) {
        StaffScreen(
            staffs = result.getOrThrow(),
            onBackAction = onBackAction
        )
    }
}