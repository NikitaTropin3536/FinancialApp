package com.atech.financialapp.component.nav

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.atech.financialapp.navigation.Bar

@Composable
fun BottomBar(
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color(0xFFF3EDF7)
    ) {

        for (bar in Bar.items) {
            val isSelected = (bar.route.toString() == currentRoute.toString())

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
                            inclusive = true
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
//                            tint = if (isSelected) Color(0xFF29E881)
//                            else Color(0xFFD4FAE6)
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