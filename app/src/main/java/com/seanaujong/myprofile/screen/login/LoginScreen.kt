package com.seanaujong.myprofile.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seanaujong.myprofile.navigation.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginState by viewModel.loginState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })

        when (loginState) {
            is LoginState.Loading -> CircularProgressIndicator()
            is LoginState.Error -> Text(text = (loginState as LoginState.Error).message, color = Color.Red)
            is LoginState.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(Screen.LoggedInHome.route) {
                        popUpTo(Screen.LoggedOutHome.route) { inclusive = true }
                    }
                }
            }
            else -> {}
        }

        Button(onClick = { viewModel.login(email, password) }) {
            Text("Sign In")
        }

        Button(onClick = { navController.navigate(Screen.SignUp.route) }) {
            Text("Sign Up")
        }
    }
}

