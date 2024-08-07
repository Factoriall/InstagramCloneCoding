package com.example.instagramclonecoding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by fac.toriall on 2024.08.07..
 */
const val HOME = "home"

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Home Screen",
            modifier = Modifier.align(Alignment.Center),
            color = Color.White
        )
    }
}