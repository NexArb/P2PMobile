package com.dag.nexarbmobile.composebase.navcontroller

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.composebase.NexarbSurface
import com.dag.nexarbmobile.composebase.appbar.CustomAppbar
import com.dag.nexarbmobile.composebase.bottomnavigation.CustomBottomNavigation
import com.dag.nexarbmobile.localdatastorage.preferencesdatastore.PreferencesDataStore
import com.dag.nexarbmobile.ui.home.HomeActivity
import com.dag.nexarbmobile.ui.onboard.intro.IntroScreen
import com.dag.nexarbmobile.ui.onboard.intro.IntroVM
import com.dag.nexarbmobile.ui.onboard.splash.SplashScreen
import com.dag.nexarbmobile.ui.onboard.splash.SplashVM
import com.dag.nexarbmobile.ui.onboard.userop.register.RegisterScreen
import com.dag.nexarbmobile.ui.onboard.userop.register.RegisterVM

@Composable
fun NavGraph(
    startDestination: String = NavScreen.WelcomeScreen.route,
    isOnboard: Boolean = false,
    preferencesDataStore: PreferencesDataStore
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NexarbSurface(
        appbar = {
            if (!isOnboard) {
                CustomAppbar()
            }
        },
        bottomBar = {
            if (!isOnboard) {
                CustomBottomNavigation(
                    currentRoute = currentRoute ?: "",
                    navController = navController
                )
            }
        },
        backgroundColor = Color.LightGray
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavScreen.WelcomeScreen.route) {
                val viewModel = hiltViewModel<SplashVM>()
                SplashScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable(NavScreen.IntroScreen.route) {
                val viewModel = hiltViewModel<IntroVM>()
                IntroScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable(NavScreen.RegisterScreen.route) {
                val viewModel = hiltViewModel<RegisterVM>()
                RegisterScreen(
                    navController = navController,
                    viewModel = viewModel
                )
            }
            composable(NavScreen.MainActivity.route){
                HomeActivity()
            }
        }
    }
}

fun NavHostController.navigateAndReplaceStartRoute(newHomeRoute: String,popStackRoute:String) {
    popBackStack(popStackRoute, true)
    graph.setStartDestination(newHomeRoute)
    navigate(newHomeRoute)
}