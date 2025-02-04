package com.seanaujong.myprofile.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.seanaujong.myprofile.screen.lihp.LoggedInHomeScreen
import com.seanaujong.myprofile.screen.login.LoginScreen
import com.seanaujong.myprofile.screen.lohp.LoggedOutHomeScreen
import com.seanaujong.myprofile.screen.settings.AccountSettingsScreen
import com.seanaujong.myprofile.screen.signup.SignUpScreen

@Composable
fun AppNavigation(
    sessionViewModel: SessionViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val isSignedIn by sessionViewModel.isSignedIn.collectAsState(initial = false)

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute by remember {
        derivedStateOf { currentBackStackEntry?.destination?.route }
    }

    val flow = if (isSignedIn) "logged_in_flow" else "logged_out_flow"

    // Automatically navigate when signed-in state changes
    LaunchedEffect(isSignedIn) {
        navController.navigate(flow) {
            popUpTo(0) { inclusive = true }
        }
    }

    Scaffold(
        bottomBar = {
            if (isSignedIn)
                LoggedInBottomNav(navController, currentRoute)
            else
                LoggedOutBottomNav(navController, currentRoute)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = flow,
            modifier = Modifier.padding(paddingValues)
        ) {
            // Logged-out flow
            navigation(startDestination = Screen.LoggedOutHome.route, route = "logged_out_flow") {
                composable(Screen.LoggedOutHome.route) { LoggedOutHomeScreen(navController) }
                composable(Screen.Login.route) { LoginScreen(navController) }
                composable(Screen.SignUp.route) { SignUpScreen(navController) }
            }

            // Logged-in flow
            navigation(startDestination = Screen.LoggedInHome.route, route = "logged_in_flow") {
                composable(Screen.LoggedInHome.route) { LoggedInHomeScreen(navController)  }
                composable(Screen.AccountSettings.route) { AccountSettingsScreen(navController) }
            }
        }
    }
}




