package com.capstone.composeapp.presentations.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.capstone.composeapp.presentations.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navHostController: NavHostController){
    TopAppBar(
        modifier= Modifier
            .height(30.dp)
            .padding(top = 5.dp),
        title = { Text(text = "List Tanaman") },
        actions = {
            IconButton(onClick = { navHostController.navigate(Screens.AboutScreen.route) }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "",
                    Modifier.size(width = 20.dp, height = 20.dp))
            }
        }
    )
}