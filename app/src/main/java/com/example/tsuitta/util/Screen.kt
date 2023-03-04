package com.example.tsuitta.util

sealed class Screen(val route: String) {
    object UsersScreen : Screen("users_screen")
    object TweetsScreen : Screen("tweets_screen")
    object ProfileScreen : Screen("profile_screen")
}