package com.albert.home.compose.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.albert.features.home.R

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun NetworkImage(
    imageUrl: String,
    nonSuccessTintColor: Color,
    modifier: Modifier = Modifier,
    builder: ImageRequest.Builder.() -> Unit = {
        placeholder(R.drawable.ic_android_white)
        error(R.drawable.ic_android_white)
    },
) {
    val painter = rememberImagePainter(
        data = imageUrl,
        onExecute = { _, _ -> true },
        builder = builder,
    )

    Image(
        modifier = modifier,
        // painter = painterResource(R.drawable.ic_android_white),
        painter = painter,
        contentDescription = null
    )
}