package com.albert.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.albert.navigator.DetailNavigator
import com.albert.ui_core_compose.setThemeContent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    @Inject
    lateinit var detailNavigator: DetailNavigator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            ScheduleScreen {
                detailNavigator.openDetail(
                    context = requireContext(),
                    /** TBD */
                    0
                )
            }
        }
    }
}