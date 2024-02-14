package com.dag.nexarbmobile.composebase.bottomnavigation


import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.ui.theme.HomeListRowButtonColor
import com.dag.nexarbmobile.ui.theme.UnSelectedBottomItem


@Composable
fun CustomBottomNavigation(
    currentRoute: String,
    navController:NavHostController
) {
    var context = LocalContext.current
    Box(
    ) {
        BottomNavigation(
            modifier = Modifier
                .height(40.dp)
                .align(Alignment.BottomCenter),
            backgroundColor = Color.White
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.size(50.dp))
                BarItem.values().forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        unselectedContentColor = UnSelectedBottomItem,
                        selectedContentColor = HomeListRowButtonColor,
                        onClick = {
                            if (currentRoute == it.route) {
                                return@BottomNavigationItem
                            } else {
                                navController.navigate(it.route) {
                                    NavScreen.HomeScreen.route.let {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }

                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = it.icon),
                                contentDescription = ""
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.size(60.dp))
            }
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(
                    bottom = 20.dp,
                    end = 20.dp
                ),
            backgroundColor = HomeListRowButtonColor,
            onClick = {

            }
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.White
            )
        }
    }
}

@Composable
@Preview
fun BottomNavigationPreview(){
    CustomBottomNavigation(
        currentRoute = NavScreen.HomeScreen.route,
        navController = rememberNavController()
    )
}


