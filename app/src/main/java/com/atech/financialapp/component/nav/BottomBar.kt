package com.atech.financialapp.component.nav

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.atech.financialapp.navigation.navBarItems

@Composable
fun BottomBar(
    navHostController: NavHostController,
) {

    // Получаем текущее состояние экрана в стеке навигации
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.surface,
    ) {

        navBarItems.forEach { item ->

            // Определяем, выбран ли текущий пункт навигации
            val isSelected = currentDestination?.hierarchy?.any {
                it.hasRoute(item.route::class)
            } == true

            NavigationBarItem(
                selected = isSelected, // Передаем статус выбора элемента

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.surfaceTint,
                    unselectedIconColor = MaterialTheme.colorScheme.surfaceContainer,
                    indicatorColor = MaterialTheme.colorScheme.outline,
                ),

                onClick = {
                    navHostController.navigate(item.route) {
                        // Очищаем предыдущий экран перед переходом
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            inclusive = true   // Включаем удаление предыдущего экрана
                            saveState = true   // Сохраняем состояние предыдущего экрана
                        }
                        launchSingleTop = true // Переход заменяет верхний экран
                        restoreState = true    // Восстанавливаем состояние нового экрана
                    }
                },

                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.title)
                    )
                },

                label = {
                    Text(
                        text = stringResource(id = item.title),
                        color = MaterialTheme.colorScheme.surfaceContainer,
                        fontWeight = if (isSelected) FontWeight.ExtraBold
                        else FontWeight.Medium,
                        fontSize = 12.sp,      // Размер шрифта
                        lineHeight = 16.sp,    // Высота строки
                    )
                }

            )

        }

    }

}