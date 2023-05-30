package com.capstone.composeapp.data.local

import androidx.compose.ui.res.painterResource
import com.capstone.composeapp.R
import com.capstone.composeapp.domain.model.Plant

object PlantData {
    val plants = listOf<Plant>(
        Plant(
            name = "Keladi Hias",
            image = painterResource(id = R.drawable.keladi_hias)
        )
    )
}