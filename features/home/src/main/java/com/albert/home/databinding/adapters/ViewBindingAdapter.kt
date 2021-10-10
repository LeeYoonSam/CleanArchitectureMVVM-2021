package com.albert.home.databinding.adapters

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.albert.home.ui.SponsorItemDecoration
import com.albert.home.ui.adapter.SponsorAdapter
import com.albert.home.util.clearItemDecoration
import com.albert.shared.model.Sponsor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate

private const val SCROLL_DX = 5

@BindingAdapter("sponsors", "itemHandler", "coroutineScope")
fun RecyclerView.bindSponsors(
    items: List<Sponsor>?,
    itemHandler: SponsorAdapter.ItemHandler,
    coroutineScope: CoroutineScope
) {
    clearItemDecoration()
    if (items?.isNotEmpty() == true) {
        adapter = SponsorAdapter((items + items), itemHandler)
        addItemDecoration(SponsorItemDecoration())
    }

    coroutineScope.launch {
        launchAutoScroll()
    }
}

private tailrec suspend fun RecyclerView.launchAutoScroll() {
    smoothScrollBy(SCROLL_DX, 0)
    val firstVisibleItem =
        (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
    if (firstVisibleItem > 0) {
        val sponsorAdapter = (adapter as SponsorAdapter)
        val currentList = sponsorAdapter.currentList
        val secondPart = currentList.subList(0, 1)
        val firstPart = currentList.subList(1, currentList.size)
        sponsorAdapter.submitList(firstPart + secondPart)
    }

    delay(25L)
    launchAutoScroll()
}

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
