package com.seanaujong.myprofile.data.auth

import kotlinx.coroutines.flow.StateFlow

class InMemoryAuthRepository : AuthRepository {
    override fun isSignedIn(): StateFlow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun signIn(
        email: String,
        password: String,
        onResult: (Boolean) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun signUp(
        email: String,
        password: String,
        onResult: (Boolean) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun signOut() {
        TODO("Not yet implemented")
    }
}