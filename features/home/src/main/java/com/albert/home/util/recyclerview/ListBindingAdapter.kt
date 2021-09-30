package com.albert.home.util.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.albert.home.util.DataBindingViewHolder

abstract class ListBindingAdapter<T>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBindingViewHolder<T>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return DataBindingViewHolder(binding)
    }

    final override fun onBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) {
        viewBindViewHolder(holder, position)
        holder.bind(getItem(position))
    }

    protected open fun viewBindViewHolder(holder: DataBindingViewHolder<T>, position: Int) {}
}