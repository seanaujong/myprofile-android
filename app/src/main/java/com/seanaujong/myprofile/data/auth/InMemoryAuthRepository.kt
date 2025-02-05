package com.seanaujong.myprofile.data.auth

import kotlinx.coroutines.flow.StateFlow

class InMemoryAuthRepository : AuthRepository {
    override val currentUser: StateFlow<UserAccount?>
        get() = TODO("Not yet implemented")

    override suspend fun signIn(
        email: String,
        password: String
    ): Result<UserAccount> {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(
        email: String,
        password: String
    ): Result<UserAccount> {
        TODO("Not yet implemented")
    }
}