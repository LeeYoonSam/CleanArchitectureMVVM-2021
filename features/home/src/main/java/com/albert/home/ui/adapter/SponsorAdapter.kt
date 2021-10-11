package com.albert.home.ui.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
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

@Composable
fun SponsorItem(
    sponsor: Sponsor,
    itemHandler: SponsorAdapter.ItemHandler
) {
    Row(
        modifier = Modifier.height(22.dp)
            .wrapContentWidth()
    ) {
        Image(
            painter = rememberImagePainter(
                data = sponsor.photoUrl,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null
        )
    }
}