package com.seanaujong.myprofile.usecase

import com.seanaujong.myprofile.data.auth.UserAccount
import com.seanaujong.myprofile.internal.Response

class SignUp (private val signUpProvider: SignUpProvider) {
    suspend operator fun invoke(email: String, password: String): Response<UserAccount> {
        val result = signUpProvider.signUp(email, password)
        return result.fold(
            onSuccess = { user -> Response.Success(user) },
            onFailure = { error -> Response.Error(error.message ?: "Unknown signup error") },
        )
    }
}

interface SignUpProvider {
    suspend fun signUp(email: String, password: String): Result<UserAccount>
}
