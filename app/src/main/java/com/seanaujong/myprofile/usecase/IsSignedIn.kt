package com.seanaujong.myprofile.usecase

import com.seanaujong.myprofile.data.auth.CurrentUserProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class IsSignedIn(val currentUserProvider: CurrentUserProvider) {

    operator fun invoke(): StateFlow<Boolean> =
        currentUserProvider.currentUser
            .map { it != null }
            .stateIn(
                scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = false
            )
}