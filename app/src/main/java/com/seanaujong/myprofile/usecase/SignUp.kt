package com.seanaujong.myprofile.usecase

import com.seanaujong.myprofile.data.auth.AuthRepository

class SignUp(private val authRepository: AuthRepository) {
    operator fun invoke(email: String, password: String, onResult: (Boolean) -> Unit) {
        authRepository.signUp(email, password, onResult)
    }
}
