package com.example.littlelemon

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.components.Home
import com.example.littlelemon.components.Onboarding
import com.example.littlelemon.components.Profile

@Composable
fun Navigation(modifier: Modifier = Modifier, navController: NavHostController) {
    val context = LocalContext.current
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    val firstName = sharedPreferences.getString("FIRST_NAME", "") ?: ""
    val lastName = sharedPreferences.getString("LAST_NAME", "") ?: ""
    val email = sharedPreferences.getString("EMAIL", "") ?: ""
    NavHost(
        navController = navController,
        startDestination = if (!firstName.isBlank() && !lastName.isBlank() && !email.isBlank()) OnBoarding.route else OnBoarding.route
    ) {
        composable(OnBoarding.route) {
            Onboarding(modifier = modifier) {
                navController.navigate(Home.route)
            }
        }
        composable(Home.route) {
            Home(modifier = modifier) {
                navController.navigate(Profile.route)
            }
        }
        composable(Profile.route) {
            Profile(modifier = modifier) {
                navController.navigate(OnBoarding.route)
            }
        }
    }
}