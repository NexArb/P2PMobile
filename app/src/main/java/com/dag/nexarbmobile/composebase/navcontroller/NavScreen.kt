package com.dag.nexarbmobile.composebase.navcontroller

sealed class NavScreen(val route:String) {

    object WelcomeScreen : NavScreen("welcome_screen")
    object IntroScreen : NavScreen("intro_screen")
    object LoginScreen:NavScreen("login_screen")
    object RegisterScreen:NavScreen("register_screen")
    object HomeScreen:NavScreen("home_screen")
    object HomeListScreen:NavScreen("homelist_screen")
    object MainActivity:NavScreen("mainactivity_screen")

}

fun NavScreen.addData(data:Any):String{
    return this.route.plus(data)
}

fun NavScreen.addPath(path:String):String{
    return this.route.plus("/").plus(path)
}