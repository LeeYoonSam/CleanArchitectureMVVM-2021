package com.albert.setting.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albert.setting.ui.compose.NetworkImage
import com.albert.shared.model.User
import com.albert.core_ui_compose.util.toColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun StaffScreen(
    modifier: Modifier = Modifier,
    staffs: List<User>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(10.dp)
    ) {
        items(staffs) { user ->
            StaffProfile(
                modifier = Modifier.padding(10.dp),
                user = user
            )
        }
    }
}

@Composable
private fun StaffProfile(
    modifier: Modifier = Modifier,
    user: User
) {
    Card(
        modifier = modifier.aspectRatio(0.75f),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NetworkImage(
                imageUrl = user.photoUrl,
                nonSuccessTintColor = "#43B1B3".toColor(),
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = user.name,
                    color = "#2F2E32".toColor(),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = user.companyName.orEmpty(),
                    color = "#9A9A9A".toColor(),
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(widthDp = 200)
@Composable
private fun StaffProfilePreview() {
    Surface(Modifier.padding(10.dp)) {
        StaffProfile(
            user = User(
                name = "사용자 이름",
                photoUrl = "",
                companyName = "회사이름"
            )
        )
    }
}