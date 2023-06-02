package com.capstone.composeapp.presentations.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.capstone.composeapp.domain.model.Plant
import com.capstone.composeapp.presentations.ui.navigation.Screens
import com.capstone.composeapp.presentations.ui.viewmodel.SharedViewModel

@Composable
fun PlantItem(
    id:Int,
    name: String,
    image: String,
    description: String,
    famili:String,
    tempatAdaptasi:String,
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    sharedViewModel: SharedViewModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                val plant = Plant(
                    id = id,
                    name = name,
                    image = image,
                    body = description,
                    famili = famili,
                    tempatAdaptasi = tempatAdaptasi
                )
                sharedViewModel.setPlantDetail(plant)
                navHostController.navigate(Screens.DetailScreen.route)
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
        Text(
            text = description,
            maxLines=2,
            lineHeight=1.5.em,
            fontWeight = FontWeight.Normal,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
        )
    }
}