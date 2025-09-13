package com.shekoo.meditate.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.shekoo.meditate.R
import com.shekoo.meditate.ui.theme.AquaBlue
import com.shekoo.meditate.ui.theme.ButtonBlue
import com.shekoo.meditate.ui.theme.DeepBlue
import com.shekoo.meditate.ui.theme.TextWhite

enum class NavRoutes(
    val route: String,
    val label: String,
    @DrawableRes val icon: Int,
    val contentDescription: String
) {
    Home("home_screen", "Home", R.drawable.ic_home, "Home"),
    Meditate("meditate_screen", "Meditate", R.drawable.ic_bubble, "Meditate"),
    Sleep("sleep_screen", "Sleep", R.drawable.ic_moon, "Sleep"),
    Music("music_screen", "Music", R.drawable.ic_music, "Music"),
    Profile("profile_screen", "Profile", R.drawable.ic_profile, "Profile")

}

@Destination<RootGraph>(start = true)
@Composable
fun NavigationScreen(navController: DestinationsNavigator) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Scaffold(
        containerColor = DeepBlue,

        modifier = Modifier.background(DeepBlue),
        topBar = { AppBar() },
        bottomBar = {
            val navBarColors = NavigationBarItemColors(
                selectedIconColor = ButtonBlue,
                selectedTextColor = TextWhite,
                unselectedTextColor = AquaBlue,
                unselectedIconColor = AquaBlue,
                disabledIconColor = AquaBlue,
                disabledTextColor = AquaBlue,
                selectedIndicatorColor = ButtonBlue
            )
            NavigationBar(
                containerColor = DeepBlue,
                windowInsets = NavigationBarDefaults.windowInsets) {
                NavRoutes.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        colors = navBarColors,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = destination.icon),
                                contentDescription = "Home",
                                tint = TextWhite,
                                modifier = Modifier.size(16.dp)
                            )
                        },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {
            when (selectedIndex) {
                0 -> HomeScreen(navController)
                1 -> Text(text = "Meditate")
                2 -> Text(text = "Sleep")
                3 -> Text(text = "Music")
                4 -> Text(text = "Profile")
            }
        }
    }
}