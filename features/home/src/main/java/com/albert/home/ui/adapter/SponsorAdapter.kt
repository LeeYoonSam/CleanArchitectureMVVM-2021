package com.albert.home.ui.adapter

import com.albert.features.home.BR
import com.albert.features.home.R
import com.albert.home.util.DataBindingViewHolder
import com.albert.home.util.recyclerview.ItemDiffCallback
import com.albert.home.util.recyclerview.ListBindingAdapter
import com.albert.shared.model.Sponsor

class SponsorAdapter(
    sponsors: List<Sponsor>,
    private val itemHandler: ItemHandler
) : ListBindingAdapter<Sponsor>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.name == new.name },
    onContentsTheSame = { old, new -> old == new }
)) {

    init {
        submitList(sponsors)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_sponsor
    }

    override fun viewBindViewHolder(holder: DataBindingViewHolder<Sponsor>, position: Int) {
        super.viewBindViewHolder(holder, position)
        holder.binding.setVariable(BR.itemHandler, itemHandler)
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }
}