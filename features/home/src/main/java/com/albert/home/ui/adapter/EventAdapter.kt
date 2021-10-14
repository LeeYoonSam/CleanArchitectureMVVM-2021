package com.albert.home.ui.adapter

import com.albert.features.home.BR
import com.albert.features.home.R
import com.albert.home.util.DataBindingViewHolder
import com.albert.home.util.recyclerview.ItemDiffCallback
import com.albert.home.util.recyclerview.ListBindingAdapter
import com.albert.shared.model.Event

internal class EventAdapter(
    events: List<Event>,
    private val itemHandler: ItemHandler
) : ListBindingAdapter<Event>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.date == new.date },
    onContentsTheSame = { old, new -> old == new }
)) {

    init {
        submitList(events)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_event
    }

    override fun viewBindViewHolder(holder: DataBindingViewHolder<Event>, position: Int) {
        super.viewBindViewHolder(holder, position)
        holder.binding.setVariable(BR.itemHandler, itemHandler)
    }

    fun interface ItemHandler {
        fun clickEvent(event: Event)
    }
}