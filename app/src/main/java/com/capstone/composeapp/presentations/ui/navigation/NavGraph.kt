package com.capstone.composeapp.presentations.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.capstone.composeapp.presentations.ui.ListScreen

@Composable
fun navGraph(navController: NavHostController){
    NavHost(navController = navController,  startDestination = Screens.ListScreen.route){
        composable(route = Screens.ListScreen.route){
            Box(modifier = Modifier.fillMaxSize()){
                ListScreen(navHostController = navController)
            }
        }
    }
}