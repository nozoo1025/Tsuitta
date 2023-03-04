package com.example.tsuitta.presentation.users

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tsuitta.domain.usecase.user.UserUseCases
import com.example.tsuitta.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val userUseCases: UserUseCases
) : ViewModel() {

    var state = mutableStateOf(UsersUiState())
        private set

    init {
       getUsers()
    }

    private fun getUsers() {
        userUseCases.getUsers()
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        state.value = UsersUiState(users = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        state.value =
                            UsersUiState(error = result.message ?: "Unexpected Error Occurred")
                    }
                    is Resource.Loading -> {
                        state.value = UsersUiState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }
}