package com.example.instagramclonecoding

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

const val INTRO = "intro"
/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by fac.toriall on 2024.08.07..
 */
@Composable
fun IntroScreen(
    modifier: Modifier = Modifier,
    onIntroFinished: () -> Unit = {}
) {
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        onIntroFinished()
    }
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        FlipCard(
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}


@Composable
fun FlipCard(
    modifier: Modifier = Modifier,
) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            )
        ), label = ""
    )

    Image(
        painter = painterResource(id = R.drawable.millennium),
        contentDescription = null,
        modifier = modifier
            .graphicsLayer {
                rotationY = angle
                cameraDistance = 12f * density
            },
        colorFilter = ColorFilter.tint(Color.White),
    )

}

@Composable
@Preview
fun PreviewIntroScreen() {
    IntroScreen(
        Modifier.paint(
            painter = painterResource(R.drawable.neon_background),
            contentScale = ContentScale.FillBounds
        )
    )
}

