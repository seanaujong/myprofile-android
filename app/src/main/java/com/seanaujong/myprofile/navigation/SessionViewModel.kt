package com.seanaujong.myprofile.navigation

import androidx.lifecycle.ViewModel
import com.seanaujong.myprofile.data.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    authRepository: AuthRepository
) : ViewModel() {

    val isSignedIn: StateFlow<Boolean> = authRepository.isSignedIn()

}
