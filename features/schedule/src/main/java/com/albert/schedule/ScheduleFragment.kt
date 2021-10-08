package com.albert.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.albert.navigator.DetailNavigator
import com.albert.core_ui_compose.layout.FullScreenLoading
import com.albert.core_ui_compose.layout.LoadingContent
import com.albert.core_ui_compose.setThemeContent
import com.albert.core_ui_compose.state.UiState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    @Inject
    lateinit var detailNavigator: DetailNavigator

    private val viewModel by viewModels<ScheduleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            val result by viewModel.sessions.observeAsState(UiState.loading())
            val scrollState = rememberScrollState()

            LoadingContent(
                loading = result.initialLoad,
                loadingContent = { FullScreenLoading() },
                error = result.hasError,
                errorContent = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(scrollState)
                            .padding(24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Warning,
                            modifier = Modifier.size(64.dp),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = result.exception?.localizedMessage.orEmpty(),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            ) {
                ScheduleScreen(
                    sessions = result.getOrThrow()
                ) { session ->
                    detailNavigator.openDetail(requireContext(), session)
                }
            }
        }
    }
}