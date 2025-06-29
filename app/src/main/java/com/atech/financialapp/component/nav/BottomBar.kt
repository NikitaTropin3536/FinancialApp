package com.atech.financialapp.component.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.atech.financialapp.navigation.Bar

@Composable
fun BottomBar(
    navController: NavController
) {

    val currentRoute = navController
        .currentBackStackEntryAsState()
        .value?.destination?.route

    NavigationBar(
        containerColor = Color(0xFFF3EDF7)
    ) {

        for (bar in Bar.items) {
            val isSelected = bar.route.toString() == currentRoute.toString()

            // Item навигационной панели
            NavigationBarItem(
                selected = isSelected,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF29E881),
                    unselectedIconColor = Color(0xFF1D1B20),
                    indicatorColor = Color(0xFFD4FAE6)
                ),

                onClick = {
                    navController.navigate(bar.route) {
                        // Очищаем стек до текущего маршрута
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Не добавляем дубликаты экранов в стек
                        launchSingleTop = true
                        // Сохраняем состояние экрана
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        painter = painterResource(id = bar.icon),
                        contentDescription = stringResource(id = bar.title), // Описание иконки
//                        tint = if (isSelected) MaterialTheme.colorScheme.surfaceTint
//                        else MaterialTheme.colorScheme.inverseOnSurface
                    )
                },

                label = {
                    Text(
                        text = stringResource(id = bar.title),
                        color = Color(0xFF1D1B20),
//                        fontWeight = if (isSelected) FontWeight(600)
//                        else FontWeight(500),
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        letterSpacing = 0.5.sp
                    )
                }

            )

        }

    }

}