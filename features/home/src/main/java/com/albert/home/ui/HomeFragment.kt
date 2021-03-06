package com.albert.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.albert.features.home.R
import com.albert.features.home.databinding.FragmentHomeBinding
import com.albert.home.ui.adapter.EventAdapter
import com.albert.home.ui.adapter.HeaderAdapter
import com.albert.home.ui.adapter.InfoAdapter
import com.albert.shared.model.Event
import com.albert.shared.model.Sponsor
import com.albert.home.util.startOpenUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentHomeBinding?>(inflater, R.layout.fragment_home, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.homeInfo.observe(viewLifecycleOwner) {
            val concatAdapter = ConcatAdapter(
                ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
                HeaderAdapter(),
                InfoAdapter(it.sponsors) { sponsor ->
                    requireContext().startOpenUrl(sponsor.homepage)
                },
                EventAdapter(it.events) { event -> requireContext().startOpenUrl(event.url) }
            )
            binding.recyclerView.adapter = concatAdapter
            binding.recyclerView.addItemDecoration(EventItemDecoration(view.context))
        }
    }
}
