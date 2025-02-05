package com.seanaujong.myprofile.data.auth

import com.seanaujong.myprofile.usecase.SignInProvider
import com.seanaujong.myprofile.usecase.SignOutProvider
import com.seanaujong.myprofile.usecase.SignUpProvider
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository : CurrentUserProvider, SignInProvider, SignOutProvider, SignUpProvider

interface CurrentUserProvider {
    val currentUser: StateFlow<UserAccount?>
}

interface UserAccount {
    val uid: String
    val email: String?
    val displayName: String?
}
