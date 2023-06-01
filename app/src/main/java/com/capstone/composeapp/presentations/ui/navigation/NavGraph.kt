package com.capstone.composeapp.presentations.ui.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.capstone.composeapp.domain.model.Plant
import com.capstone.composeapp.presentations.ui.AboutScreen
import com.capstone.composeapp.presentations.ui.DetailScreen
import com.capstone.composeapp.presentations.ui.ListScreen
import com.capstone.composeapp.presentations.ui.viewmodel.SharedViewModel

@Composable
fun NavGraph(navController: NavHostController){
    val sharedViewModel:SharedViewModel = viewModel()
    NavHost(navController = navController,  startDestination = Screens.ListScreen.route){
        composable(route = Screens.ListScreen.route){
            Box(modifier = Modifier.fillMaxSize()){
                ListScreen(navHostController = navController, sharedViewModel = sharedViewModel)
            }
        }
        composable(
            route = Screens.DetailScreen.route,
        ){
            LaunchedEffect(key1 = it){
                val result = navController.previousBackStackEntry?.savedStateHandle?.get<Plant>("plant")
                Log.d("DetailScreen","${result?.name}")
            }
            DetailScreen(sharedViewModel = sharedViewModel)
        }
        composable(
            route = Screens.AboutScreen.route
        ){
            AboutScreen()
        }
    }
}