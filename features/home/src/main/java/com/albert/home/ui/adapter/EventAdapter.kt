package com.albert.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.albert.features.home.R
import com.albert.home.util.DataBindingAdapter
import com.albert.shared.model.Event

internal class EventAdapter(
    events: List<Event>
) : DataBindingAdapter<Event>(DiffCallback()) {
    init {
        submitList(events)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_event
    }

    private class DiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }
}