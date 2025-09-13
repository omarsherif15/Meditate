package com.shekoo.meditate

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.shekoo.meditate.R.*
import com.shekoo.meditate.ui.MeditateCard
import com.shekoo.meditate.ui.theme.Beige2
import com.shekoo.meditate.ui.theme.Beige3

data class MeditateFeature(
    val title: String,
    @DrawableRes val icon: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)


