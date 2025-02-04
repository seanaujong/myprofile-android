package com.seanaujong.myprofile.screen.lihp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.seanaujong.myprofile.navigation.Screen

@Composable
fun LoggedInHomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "Welcome to your home screen!")
        Button(onClick = { navController.navigate(Screen.AccountSettings.route) }) {
            Text("Go to Account Settings")
        }
    }
}
