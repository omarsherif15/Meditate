package com.shekoo.meditate.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.LinearGradient
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.generated.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.shekoo.meditate.MeditateFeature
import com.shekoo.meditate.R
import com.shekoo.meditate.Routes
import com.shekoo.meditate.ui.theme.AquaBlue
import com.shekoo.meditate.ui.theme.Beige1
import com.shekoo.meditate.ui.theme.Beige2
import com.shekoo.meditate.ui.theme.Beige3
import com.shekoo.meditate.ui.theme.BlueViolet1
import com.shekoo.meditate.ui.theme.BlueViolet2
import com.shekoo.meditate.ui.theme.BlueViolet3
import com.shekoo.meditate.ui.theme.ButtonBlue
import com.shekoo.meditate.ui.theme.DarkerButtonBlue
import com.shekoo.meditate.ui.theme.DeepBlue
import com.shekoo.meditate.ui.theme.LightGreen1
import com.shekoo.meditate.ui.theme.LightGreen2
import com.shekoo.meditate.ui.theme.LightGreen3
import com.shekoo.meditate.ui.theme.LightRed
import com.shekoo.meditate.ui.theme.OrangeYellow1
import com.shekoo.meditate.ui.theme.OrangeYellow2
import com.shekoo.meditate.ui.theme.OrangeYellow3
import com.shekoo.meditate.ui.theme.TextWhite

@Composable
fun HomeScreen(navController: DestinationsNavigator){
    val features = listOf(
        MeditateFeature(
            title = "Sleep Meditation",
            R.drawable.ic_headphone,
            Beige1,
            Beige2,
            Beige3
        ),
        MeditateFeature(
            title = "Tips for sleeping",
            R.drawable.ic_videocam,
            LightGreen1,
            LightGreen2,
            LightGreen3
        ),
        MeditateFeature(
            title = "Night island",
            R.drawable.ic_headphone,
            BlueViolet1,
            BlueViolet2,
            BlueViolet3
        ),
        MeditateFeature(
            title = "Calming sounds",
            R.drawable.ic_headphone,
            OrangeYellow1,
            OrangeYellow2,
            OrangeYellow3
        ))


    Box(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepBlue)
        ) {
            Column {
                ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression"))
                HomeBanner(navController)
                Text(
                    text = "Featured",
                    style = MaterialTheme.typography.headlineLarge,
                    color = TextWhite,
                    modifier = Modifier.padding(15.dp)
                )
                FeatureGrid(features = features)
            }
        }
    }

@Composable
fun AppBar (
    name: String = "Philip"
){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Text(
                    text = "Good Morning, $name",
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "We wish you have a good day!",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = TextWhite,
                modifier = Modifier.size(24.dp)
            )
        }
}

@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChip by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size){
            Box(
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable(
                        onClick = {
                            selectedChip = it
                        }
                    )
                    .background(
                        if (selectedChip == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)


            ){
                Text(
                    text = chips[it],
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (selectedChip == it) TextWhite else AquaBlue
                )
            }
        }
    }
}

@Composable
fun HomeBanner (navC: DestinationsNavigator){

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(LightRed)
                .padding(horizontal = 15.dp, vertical = 30.dp)

        ) {
            Column {
                Text(
                    text = "Daily Thought",
                    style = MaterialTheme.typography.headlineMedium,
                    color = TextWhite
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Meditation * 3-10 min",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextWhite
                )
            }

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(ButtonBlue)
                    .padding(10.dp)
                    .clickable { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "Play",
                    tint = TextWhite,
                    modifier = Modifier.size(16.dp)
                        .clickable(
                            onClick = {
                                navC.navigate(
                                    DetailsScreenDestination()
                                )
                            }

                        )
                )
            }


        }
}

@Composable
fun MeditateCard(
    feature: MeditateFeature
){

    Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .aspectRatio(1f)
                .padding(7.5.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(
                            feature.darkColor,
                            feature.lightColor
                        )
                    )
                )
                .padding(horizontal = 15.dp, vertical = 30.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                color = TextWhite
            )
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = feature.icon),
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

}

@Composable
fun FeatureGrid(
    features: List<MeditateFeature>
){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
    ) {
        items(features.size) {
            MeditateCard(feature = features[it])
        }

    }
}