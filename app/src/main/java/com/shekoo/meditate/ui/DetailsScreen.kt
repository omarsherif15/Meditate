@file:OptIn(ExperimentalMaterial3Api::class)

package com.shekoo.meditate.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.shekoo.meditate.MeditateFeature
import com.shekoo.meditate.R
import com.shekoo.meditate.ui.theme.Beige1
import com.shekoo.meditate.ui.theme.BlueViolet1
import com.shekoo.meditate.ui.theme.BlueViolet2
import com.shekoo.meditate.ui.theme.BlueViolet3
import com.shekoo.meditate.ui.theme.ButtonBlue
import com.shekoo.meditate.ui.theme.DeepBlue
import com.shekoo.meditate.ui.theme.TextWhite

@Composable
fun DetailsScreen (navController: NavHostController){
    Scaffold(
        containerColor = DeepBlue,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = DeepBlue,
                    titleContentColor = TextWhite,
                    navigationIconContentColor = TextWhite,
                    actionIconContentColor = TextWhite,
                    scrolledContainerColor = TextWhite
                ),
                actions = {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "search",
                        modifier = Modifier
                            .size(30.dp)
                            .padding(end = 10.dp)
                    )
                }
            )
                 },
    ) {
        Box(
            modifier = Modifier.padding(it)
        ){
            Column(
                modifier = Modifier.padding(15.dp)

            ) {
                Text(
                    text = "Sleep Meditation",
                    style = MaterialTheme.typography.headlineLarge,
                    color = TextWhite
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Best Practice Meditation",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(15.dp))
                DetailsCard()
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Sleep Music . 40 min",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Best Practice Meditation Sleep Music . 40 min Practice MSleep Music . 40 mintion",
                    style = MaterialTheme.typography.bodyLarge,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.25.dp)
                        .background(color = Color(0xFF777676))
                )
            }
        }
    }
}

@Composable
fun DetailsCard(
){
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            BlueViolet1,
                            BlueViolet2,
                            BlueViolet3
                        )
                    )
                )
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_headphone),
                contentDescription = "Icon",
                tint = TextWhite,
                modifier = Modifier.size(24.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10.dp),
                colors = buttonColors(
                    containerColor = ButtonBlue
                ),
            ) {
                Text(
                    text = "Start",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextWhite
                )

            }
        }
    }
