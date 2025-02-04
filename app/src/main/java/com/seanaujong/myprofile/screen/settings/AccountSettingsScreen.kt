package com.seanaujong.myprofile.screen.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seanaujong.myprofile.navigation.Screen

@Composable
fun AccountSettingsScreen(
    navController: NavController,
    viewModel: AccountSettingsViewModel = hiltViewModel()
) {
    AccountSettings(
        onSignOut = {
            viewModel.signOut()
            navController.navigate(Screen.LoggedOutHome.route) {
                popUpTo(Screen.LoggedInHome.route) { inclusive = true }
            }
        }
    )
}

@Composable
fun AccountSettings(
    onSignOut: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Account Settings")
        Button(onClick = onSignOut) {
            Text("Log Out")
        }
    }
}

@Preview
@Composable
fun AccountSettingsPreview() {
    AccountSettings({})
}

