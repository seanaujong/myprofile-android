package com.seanaujong.myprofile.screen.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.seanaujong.myprofile.navigation.Screen

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignupViewModel = hiltViewModel()
) {
    val signupState by viewModel.signupState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") })

        when (signupState) {
            is SignupState.Loading -> CircularProgressIndicator()
            is SignupState.Error -> Text(text = (signupState as SignupState.Error).message, color = Color.Red)
            is SignupState.Success -> {
                LaunchedEffect(Unit) {
                    navController.navigate(Screen.LoggedInHome.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                }
            }
            else -> {}
        }

        Button(onClick = { viewModel.signUp(email, password) }) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate(Screen.Login.route) }) {
            Text("Already have an account? Log in")
        }
    }
}
