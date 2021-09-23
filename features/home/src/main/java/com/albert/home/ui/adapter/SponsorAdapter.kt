package com.albert.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.albert.features.home.R
import com.albert.home.util.DataBindingAdapter
import com.albert.shared.model.Sponsor

internal class SponsorAdapter(
    sponsors: List<Sponsor>
) : DataBindingAdapter<Sponsor>(DiffCallback()) {

    init {
        submitList(sponsors)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_sponsor
    }

    private class DiffCallback : DiffUtil.ItemCallback<Sponsor>() {
        override fun areItemsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
            return oldItem == newItem
        }
    }
}