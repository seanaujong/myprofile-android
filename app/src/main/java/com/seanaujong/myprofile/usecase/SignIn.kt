package com.seanaujong.myprofile.usecase

import com.seanaujong.myprofile.data.auth.UserAccount
import com.seanaujong.myprofile.internal.Response

class SignIn(private val signInProvider: SignInProvider) {
    suspend operator fun invoke(email: String, password: String): Response<UserAccount> {
        val result = signInProvider.signIn(email, password)
        return result.fold(
            onSuccess = { user -> Response.Success(user) },
            onFailure = { error -> Response.Error(error.message ?: "Unknown signin error") },
        )
    }
}

interface SignInProvider {
    suspend fun signIn(email: String, password: String): Result<UserAccount>
}
