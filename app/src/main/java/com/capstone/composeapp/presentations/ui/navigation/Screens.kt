package com.capstone.composeapp.presentations.ui.navigation

sealed class Screens(val route:String) {
    object ListScreen: Screens("list_Screen")
    object DetailScreen:Screens("detail_screen")
    object AboutScreen:Screens("about_screen")
}