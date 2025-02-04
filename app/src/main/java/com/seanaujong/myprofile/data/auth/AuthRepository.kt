package com.seanaujong.myprofile.data.auth

import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    fun isSignedIn(): StateFlow<Boolean>
    fun signIn(email: String, password: String, onResult: (Boolean) -> Unit)
    fun signUp(email: String, password: String, onResult: (Boolean) -> Unit)
    fun signOut()
}
