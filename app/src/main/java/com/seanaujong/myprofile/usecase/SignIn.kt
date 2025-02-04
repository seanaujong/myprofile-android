package com.seanaujong.myprofile.usecase

import com.seanaujong.myprofile.data.auth.AuthRepository

class SignIn(private val authRepository: AuthRepository) {
    operator fun invoke(email: String, password: String, onResult: (Boolean) -> Unit) {
        authRepository.signIn(email, password, onResult)
    }
}