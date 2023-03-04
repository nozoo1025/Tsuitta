package com.example.tsuitta.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tsuitta.presentation.profile.ProfileScreen
import com.example.tsuitta.presentation.tweets.TweetsScreen
import com.example.tsuitta.presentation.ui.theme.TsuittaTheme
import com.example.tsuitta.presentation.users.UsersScreen
import com.example.tsuitta.presentation.util.CustomNavigationBar
import com.example.tsuitta.util.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TsuittaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    val navController = rememberNavController()

                    Scaffold(
                        bottomBar = {
                            CustomNavigationBar(navController)
                        }
                    ) { paddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.UsersScreen.route,
                            modifier = Modifier.padding(
                                bottom = paddingValues.calculateBottomPadding()
                            )
                        ) {
                            composable(route = Screen.UsersScreen.route) {
                                UsersScreen()
                            }
                            composable(route = Screen.TweetsScreen.route) {
                                TweetsScreen()
                            }
                            composable(route = Screen.ProfileScreen.route) {
                                ProfileScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}