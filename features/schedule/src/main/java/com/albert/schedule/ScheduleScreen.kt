package com.albert.schedule

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albert.shared.model.Session
import com.albert.core_ui_compose.util.toColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
internal fun ScheduleScreen(
    sessions: List<Session>,
    onSessionClick: (Session) -> Unit = { }
) {
    val groupingSession = sessions.groupBy {
        it.room
    }

    val rooms = groupingSession.keys.toList()
    val pagerState = rememberPagerState()

    Column(Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = rooms[pagerState.currentPage].name,
                color = "#2F2E32".toColor(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            HorizontalPagerIndicator(
                pagerState = pagerState,
                activeColor = "#4cc786".toColor(),
                inactiveColor = "#4cc786".toColor().copy(alpha = 0.3f),
                indicatorWidth = 10.dp
            )
        }

        HorizontalPager(
            count = groupingSession.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) { page ->
            Schedules(
                sessions = groupingSession[rooms.elementAt(page)].orEmpty(),
                onSessionClick = onSessionClick
            )
        }
    }
}

@Composable
private fun Schedules(
    sessions: List<Session>,
    onSessionClick: (Session) -> Unit = {}
) {
    LazyColumn {
        items(items = sessions) { session ->
            SessionUi(
                session = session,
                onSessionClick = onSessionClick
            )
            Divider(
                modifier = Modifier.padding(horizontal = 24.dp),
                color = "#EFEFEF".toColor()
            )
        }
    }
}