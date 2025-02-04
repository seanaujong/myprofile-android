package com.seanaujong.myprofile.screen.lohp

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
fun LoggedOutHomeScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = "Welcome! Please sign in to see more content.")
        Button(onClick = { navController.navigate(Screen.Login.route) }) {
            Text("Go to Login")
        }
    }
}
