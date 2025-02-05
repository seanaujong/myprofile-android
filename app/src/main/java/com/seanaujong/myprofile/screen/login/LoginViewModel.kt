package com.seanaujong.myprofile.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seanaujong.myprofile.internal.Response
import com.seanaujong.myprofile.usecase.SignIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signIn: SignIn
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            val response = signIn(email, password)
            when (response) {
                is Response.Success -> LoginState.Success
                is Response.Error -> LoginState.Error(response.message)
            }
        }
    }
}


sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}
