package com.seanaujong.myprofile.screen.settings

import androidx.lifecycle.ViewModel
import com.seanaujong.myprofile.usecase.SignOut
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountSettingsViewModel @Inject constructor(
    private val signOutUseCase: SignOut
) : ViewModel() {

    fun signOut() {
        signOutUseCase()
    }
}
