package com.capstone.composeapp.presentations.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.capstone.composeapp.data.local.PlantData
import com.capstone.composeapp.presentations.ui.components.PlantItem
import com.capstone.composeapp.presentations.ui.components.TopBar
import com.capstone.composeapp.presentations.ui.viewmodel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navHostController: NavHostController,sharedViewModel: SharedViewModel){
    Scaffold(
        modifier=Modifier.fillMaxSize(),
        topBar = { TopBar(navHostController) }
    ) {paddingValues ->
        Column(modifier=Modifier.padding(paddingValues)) {
            val plantData = remember{PlantData.plants}
            LazyColumn(modifier=Modifier.padding(paddingValues)){
                itemsIndexed(plantData){ _,plant->
                    PlantItem(
                        id=plant.id,
                        name = plant.name,
                        image = plant.image.toString(),
                        description = plant.body,
                        navHostController = navHostController,
                        sharedViewModel=sharedViewModel
                    )
                }
            }
        }
    }
}