package com.seanaujong.myprofile.navigation

sealed class Screen(val route: String) {
    // Logged-out screens
    object LoggedOutHome : Screen("logged_out_home")
    object Login : Screen("login")
    object SignUp : Screen("signup")

    // Logged-in screens
    object LoggedInHome : Screen("logged_in_home")
    object AccountSettings : Screen("account_settings")
}


