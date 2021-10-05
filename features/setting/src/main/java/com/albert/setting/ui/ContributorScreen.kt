package com.albert.setting

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.albert.setting.ui.SettingAppBar
import com.albert.setting.ui.compose.NetworkImage
import com.albert.shared.model.User
import com.albert.ui_core_compose.util.toColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ContributorScreen(
    users: List<User>
) {
    Scaffold(
        topBar = { SettingAppBar(title = "Contributors") }
    ) { innerPadding ->
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(users) { contributor ->
                ContributorProfile(
                    modifier = Modifier.padding(8.dp),
                    user = contributor
                )
            }
        }
    }
}

@Composable
private fun ContributorProfile(
    modifier: Modifier = Modifier,
    user: User
) {
    Card(
        modifier = modifier.aspectRatio(1f),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NetworkImage(
                imageUrl = user.photoUrl,
                nonSuccessTintColor = "#43B1B3".toColor(),
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape),
            )
            
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = user.name,
                color = "#2F2E32".toColor(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@OptIn(ExperimentalStdlibApi::class)
@Preview(heightDp = 250)
@Composable
fun ContributorsProfilePreview() {
    val list = buildList {
        repeat(5) {
            add(User("Droid Kngiths 2021", ""))
        }
    }
    Surface {
        ContributorScreen(list)
    }
}

@Preview(widthDp = 150, heightDp = 150)
@Composable
fun ContributorProfilePreview() {
    Surface {
        ContributorProfile(
            user = User("Droid Kngiths 2021", "")
        )
    }
}