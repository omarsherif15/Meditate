//package com.shekoo.meditate
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.*
//import com.shekoo.meditate.ui.DetailsScreen
//import com.shekoo.meditate.ui.NavigationScreen
//
//@Composable
//fun AppRouter(){
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Routes.NavigationScreen.route){
//        composable(Routes.NavigationScreen.route){
//            NavigationScreen(navController = navController)
//        }
//        composable(Routes.DetailsScreen.route){
//            DetailsScreen(navController)
//        }
//    }
//}