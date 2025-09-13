package com.shekoo.meditate

sealed class Routes(val route: String) {
    object NavigationScreen : Routes("navigation_screen")
    object DetailsScreen : Routes("details_screen")
    object HomeScreen : Routes("home_screen")
    object MeditateScreen : Routes("meditate_screen")
    object SleepScreen : Routes("sleep_screen")
    object MusicScreen : Routes("music_screen")
    object ProfileScreen : Routes("profile_screen")
}