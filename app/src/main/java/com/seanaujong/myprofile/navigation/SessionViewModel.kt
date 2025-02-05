package com.seanaujong.myprofile.navigation

import androidx.lifecycle.ViewModel
import com.seanaujong.myprofile.usecase.IsSignedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    isSignedIn: IsSignedIn
) : ViewModel() {

    val isSignedIn: StateFlow<Boolean> = isSignedIn()

}
