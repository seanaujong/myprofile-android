package com.seanaujong.myprofile.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun LoggedInBottomNav(navController: NavController, currentDestination: String?) {
    LoggedInBottomNavBar(
        currentDestination = currentDestination,
        onHomeClick = { navController.navigate(Screen.LoggedInHome.route) },
        onSettingsClick = { navController.navigate(Screen.AccountSettings.route )},
    )
}

@Composable
private fun LoggedInBottomNavBar(
    currentDestination: String?,
    onHomeClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentDestination == Screen.LoggedInHome.route,
            onClick = onHomeClick
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountBox, contentDescription = "Account Settings") },
            label = { Text("Settings") },
            selected = currentDestination == Screen.AccountSettings.route,
            onClick = onSettingsClick
        )
    }
}

@Preview
@Composable
private fun LoggedInBottomNavBarPreview() {
    LoggedInBottomNavBar(Screen.LoggedInHome.route, {}, {})
}
