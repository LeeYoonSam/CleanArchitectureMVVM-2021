package com.albert.home.compose.view

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
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

    val colorFilter = when (painter.state) {
        is ImagePainter.State.Success -> null
        else  -> ColorFilter.tint(nonSuccessTintColor)
    }

    Image(
        modifier = modifier,
        painter = painter,
        colorFilter = colorFilter,
        contentDescription = null
    )
}