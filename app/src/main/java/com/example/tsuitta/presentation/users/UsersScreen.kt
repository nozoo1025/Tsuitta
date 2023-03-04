package com.example.tsuitta.presentation.users

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tsuitta.presentation.users.components.UserItem
import com.example.tsuitta.presentation.util.SimpleAlertDialog
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun UsersScreen(
    viewModel: UsersViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val swipeRefreshState = rememberSwipeRefreshState(false)

    if (state.error.isNotBlank()) {
        SimpleAlertDialog(
            title = "Network Error",
            message = state.error,
            confirmText = "OK",
            onConfirmed = {

            }
        )
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    if (state.users.isNotEmpty()) {
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = { /*TODO*/ },
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Users",
                        fontWeight = MaterialTheme.typography.displayMedium.fontWeight,
                        fontSize = MaterialTheme.typography.displayMedium.fontSize,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(state.users) { user ->
                        UserItem(user = user)
                    }
                }
            }
        }
    }
}
