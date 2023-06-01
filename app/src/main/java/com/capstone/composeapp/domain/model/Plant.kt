package com.capstone.composeapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plant(
    val id:Int,
    val name:String,
    val image:String?="https://raw.githubusercontent.com/muhammadyaumil1313/PlantsApp/master/app/src/main/res/drawable/baseline_broken_image_24.xml",
    val body:String
):Parcelable
