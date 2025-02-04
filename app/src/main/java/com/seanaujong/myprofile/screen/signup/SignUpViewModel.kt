package com.seanaujong.myprofile.screen.signup

import androidx.lifecycle.ViewModel
import com.seanaujong.myprofile.usecase.SignUp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signUpUseCase: SignUp
) : ViewModel() {

    private val _signupState = MutableStateFlow<SignupState>(SignupState.Idle)
    val signupState: StateFlow<SignupState> = _signupState

    fun signUp(email: String, password: String) {
        _signupState.value = SignupState.Loading
        signUpUseCase(email, password) { success ->
            _signupState.value = if (success) {
                SignupState.Success
            } else {
                SignupState.Error("Sign-up failed")
            }
        }
    }
}

sealed class SignupState {
    object Idle : SignupState()
    object Loading : SignupState()
    object Success : SignupState()
    data class Error(val message: String) : SignupState()
}
