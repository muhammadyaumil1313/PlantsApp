package com.capstone.composeapp.presentations.ui

import android.util.LayoutDirection
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.capstone.composeapp.presentations.ui.viewmodel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(sharedViewModel: SharedViewModel){
    Scaffold(modifier=Modifier.fillMaxSize()) {paddingValues->
        Column(modifier=Modifier.padding(paddingValues)) {
            val plant = sharedViewModel.plantLive
            LaunchedEffect(key1 = plant){
                Log.d("data detail","${plant.value?.name}")
            }
            AsyncImage(
                model = plant.value?.image,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            val currentLayoutDir = LocalLayoutDirection.current
            Text(
                modifier=Modifier
                    .padding(start = paddingValues.calculateStartPadding(currentLayoutDir) + 10.dp),
                text = plant.value!!.name,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier=Modifier
                    .padding(20.dp),
                text = plant.value!!.body,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,
                lineHeight = 1.5.em
            )
            Row(modifier=Modifier.padding(start = 10.dp)){
                Text(text = "Famili : ",fontWeight = FontWeight.Medium)
                plant.value!!.famili?.let {text->
                    Text(
                        text = text,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Justify,
                        lineHeight = 1.5.em
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier=Modifier.padding(start = 10.dp)){
               Text(text = "Tempat Adaptasi : ", fontWeight = FontWeight.Medium)
                plant.value!!.tempatAdaptasi?.let {text->
                    Text(
                        text = text,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Justify,
                        lineHeight = 1.5.em
                    )
                }
            }
        }
    }
}