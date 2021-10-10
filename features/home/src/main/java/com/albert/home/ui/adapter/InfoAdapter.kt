package com.albert.home.ui.adapter

import com.albert.features.home.BR
import com.albert.features.home.R
import com.albert.home.util.DataBindingViewHolder
import com.albert.home.util.recyclerview.ItemDiffCallback
import com.albert.home.util.recyclerview.ListBindingAdapter
import com.albert.shared.model.Sponsor
import kotlinx.coroutines.CoroutineScope

internal class InfoAdapter(
    private val coroutineScope: CoroutineScope,
    sponsors: List<Sponsor>,
    private val itemHandler: ItemHandler
) : ListBindingAdapter<InfoItem>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.sponsors == new.sponsors },
    onContentsTheSame = { old, new -> old == new }
)) {
    init {
        submitList(listOf(InfoItem(sponsors)))
    }

    private val sponsorItemHandler = object : SponsorAdapter.ItemHandler {
        override fun clickSponsor(sponsor: Sponsor) {
            itemHandler.clickSponsor(sponsor)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_header
    }

    override fun viewBindViewHolder(holder: DataBindingViewHolder<InfoItem>, position: Int) {
        super.viewBindViewHolder(holder, position)
        holder.binding.run {
            setVariable(BR.itemHandler, sponsorItemHandler)
            setVariable(BR.coroutineScope, coroutineScope)
        }
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }
}

data class InfoItem(val sponsors: List<Sponsor>)