package com.example.instagramclonecoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instagramclonecoding.ui.theme.InstagramCloneCodingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InstagramCloneCodingTheme {
                val navController = rememberNavController()
                val currentBackStack by navController.currentBackStackEntryAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    InstagramNavHost(
                        Modifier
                            .paint(
                                painter = painterResource(R.drawable.neon_background),
                                contentScale = ContentScale.FillBounds
                            )
                            .padding(innerPadding),
                        navController
                    )
                }
            }
        }
    }
}

@Composable
fun InstagramNavHost(modifier: Modifier, navController: NavHostController) {
    val baseModifier = Modifier
    NavHost(
        navController = navController,
        startDestination = INTRO,
        modifier = modifier
    ) {
        composable(INTRO) {
            IntroScreen(
                modifier = baseModifier,
                onIntroFinished = {
                    navController.navigate(HOME) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(HOME) {
            HomeScreen(baseModifier)
        }
    }
}