package com.example.myprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myprofile.ui.theme.ProfileDetailScreen
import com.example.myprofile.ui.theme.ProfileListScreen
import com.example.myprofile.ui.theme.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: ProfileViewModel = viewModel()

            NavHost(navController = navController, startDestination = "list") {
                composable ("list") {
                    ProfileListScreen(viewModel) { id ->
                        navController.navigate("detail/$id")
                    }
                }
                composable("detail/{id}") { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")?.toInt() ?: return@composable
                    ProfileDetailScreen(viewModel, id) {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}


