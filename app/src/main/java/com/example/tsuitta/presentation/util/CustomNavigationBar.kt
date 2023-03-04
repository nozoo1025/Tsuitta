package com.example.tsuitta.presentation.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.example.tsuitta.util.Screen

private data class NavigationBarItem(
    val icon: ImageVector,
    val label: String,
    val route: String
)

@Composable
fun CustomNavigationBar(
    navController: NavController
) {
    var selectedItem by remember { mutableStateOf(Screen.UsersScreen.route) }
    val items = listOf(
        NavigationBarItem(
            Icons.Filled.Person,
            "Users",
            Screen.UsersScreen.route
        ),
        NavigationBarItem(
            Icons.Filled.Home,
            "Tweets",
            Screen.TweetsScreen.route
        ),
        NavigationBarItem(
            Icons.Filled.AccountCircle,
            "Profile",
            Screen.ProfileScreen.route
        )
    )

    DisposableEffect(key1 = navController) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            if (items.any { it.route == destination.route }) {
                selectedItem = destination.route ?: Screen.UsersScreen.route
            }
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose { navController.removeOnDestinationChangedListener(listener) }
    }

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = ""
                    )
                },
                selected = selectedItem == item.route,
                label = {
                    Text(text = item.label)
                },
                onClick = {
                    selectedItem = item.route
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            // TODO: backしたときにselectedItemと現在のルートが不一致になるバグが有る
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true

                        selectedItem = item.route
                    }
                }
            )
        }
    }
}