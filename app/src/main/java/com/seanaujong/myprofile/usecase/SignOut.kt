package com.seanaujong.myprofile.usecase

class SignOut(private val signOutProvider: SignOutProvider) {
    operator fun invoke() {
        signOutProvider.signOut()
    }
}

interface SignOutProvider {
    fun signOut()
}
