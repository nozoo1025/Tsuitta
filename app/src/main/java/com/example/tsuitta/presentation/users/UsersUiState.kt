package com.example.tsuitta.presentation.users

import com.example.tsuitta.domain.model.User

data class UsersUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)
