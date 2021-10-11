package com.albert.home.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.albert.features.home.R
import kotlin.math.roundToInt

class EventItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val itemViewType: Int = R.layout.item_event

    private val divider: Drawable =
        ContextCompat.getDrawable(context, R.drawable.event_list_divider)!!

    private var horizontalMargin: Int =
        context.resources.getDimensionPixelOffset(R.dimen.event_list_divider_margin)

    private val bounds = Rect()

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        if (parent.layoutManager == null) {
            return
        }

        c.save()
        val left = horizontalMargin
        val right = parent.width - horizontalMargin
        var previousViewType: Int? = null
        parent.children.forEach { child ->
            val adapterPosition = parent.getChildAdapterPosition(child)
            val viewType = parent.adapter?.getItemViewType(adapterPosition)
            if (viewType == itemViewType && viewType == previousViewType) {
                parent.getDecoratedBoundsWithMargins(child, bounds)
                val top: Int = bounds.top + child.translationY.roundToInt()
                val bottom: Int = top + divider.intrinsicHeight
                divider.setBounds(left, top, right, bottom)
                divider.draw(c)
            }
            previousViewType = viewType
        }
        c.restore()
    }
}