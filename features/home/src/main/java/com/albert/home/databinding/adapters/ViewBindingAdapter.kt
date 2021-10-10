package com.albert.home.databinding.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.albert.home.ui.SponsorItemDecoration
import com.albert.home.ui.adapter.SponsorAdapter
import com.albert.home.util.clearItemDecoration
import com.albert.shared.model.Sponsor
import kotlinx.datetime.LocalDate

@BindingAdapter("sponsors", "itemHandler")
fun RecyclerView.bindSponsors(items: List<Sponsor>?, itemHandler: SponsorAdapter.ItemHandler) {
    clearItemDecoration()

    if (items?.isNotEmpty() == true) {
        adapter = SponsorAdapter(items, itemHandler)
        addItemDecoration(SponsorItemDecoration())
    }
}

@BindingAdapter("eventTitle")
fun TextView.bindEventTitle(date: LocalDate) {
    text = "${date.year}년 드로이드 나이츠"
}

@BindingAdapter("bindEventDate")
fun TextView.bindEventDate(date: LocalDate) {
    text = "${date.year}년 ${date.monthNumber}월 ${date.dayOfMonth}일"
}
