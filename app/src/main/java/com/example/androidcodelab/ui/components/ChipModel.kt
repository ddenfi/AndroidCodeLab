package com.example.androidcodelab.ui.components

import androidx.annotation.DrawableRes
import com.example.androidcodelab.R

data class ChipModel(
    var selected: Boolean = false,
    var title: String,
    @DrawableRes val icon: Int = 0
)

val listDisaster = listOf(
    ChipModel(
        title = "Banjir",
        icon = R.drawable.ic_flood
    ),
    ChipModel(
        title = "Gempabumi",
        icon = R.drawable.ic_earthquake
    ),
    ChipModel(
        title = "Angin Kencang",
        icon = R.drawable.ic_air
    ),
    ChipModel(
        title = "Kabut Asap",
        icon = R.drawable.ic_haze
    ),
    ChipModel(
        title = "Kebakaran Hutan",
        icon = R.drawable.ic_fire
    ),
    ChipModel(
        title = "Gunung Api",
        icon = R.drawable.ic_volcano
    ),
)
