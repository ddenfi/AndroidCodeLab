package com.example.androidcodelab.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcodelab.ui.screens.MainViewModel
import com.example.androidcodelab.ui.screens.detail.DetailRoute
import com.example.androidcodelab.ui.screens.home.HomeRoute

@Composable
fun AppNavGraph(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(
            route = Screens.Home.route
        ){
            HomeRoute(viewModel){
                navController.navigate(Screens.Detail.route)
            }
        }

        composable(
            route = Screens.Detail.route
        ){
            DetailRoute(viewModel){
                navController.navigate(Screens.Home.route)
            }
        }
    }
}