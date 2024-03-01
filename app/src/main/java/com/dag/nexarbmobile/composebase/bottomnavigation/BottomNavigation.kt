package com.dag.nexarbmobile.composebase.bottomnavigation


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.FloatingActionButtonElevation
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dag.nexarbmobile.composebase.navcontroller.NavScreen
import com.dag.nexarbmobile.ui.theme.BackgroundColor
import com.dag.nexarbmobile.ui.theme.ColorfulButtonBackground
import com.dag.nexarbmobile.ui.theme.HomeListRowButtonColor
import com.dag.nexarbmobile.ui.theme.UnSelectedBottomItem


@Composable
fun CustomBottomNavigation(
    currentRoute: String,
    navController: NavHostController
) {
    val backgroundColor = MaterialTheme.colors.background
    BottomNavigation(
        modifier = Modifier
            .height(80.dp),
        backgroundColor = backgroundColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Canvas(
                modifier = Modifier
                    .size(65.dp)
                    .align(Alignment.TopCenter)
                    .zIndex(8f),
                onDraw = {
                    drawCircle(color = backgroundColor)
                }
            )
            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .zIndex(10f),
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 10.dp
                ),
                onClick = {

                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .align(Alignment.BottomCenter)
                    .padding(0.dp)
                    .background(MaterialTheme.colors.primaryVariant),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BarItem.entries.forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        unselectedContentColor = Color.White,
                        selectedContentColor = MaterialTheme.colors.secondary,
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
            }

        }
    }

}

@Composable
@Preview
fun BottomNavigationPreview() {
    CustomBottomNavigation(
        currentRoute = NavScreen.HomeScreen.route,
        navController = rememberNavController()
    )
}


