package com.seanaujong.myprofile.usecase

import com.seanaujong.myprofile.data.auth.AuthRepository

class SignOut(private val authRepository: AuthRepository) {
    operator fun invoke() {
        authRepository.signOut()
    }
}
