package com.atech.financialapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.atech.financialapp.component.nav.BottomBar
import com.atech.financialapp.component.nav.TopBar
import com.atech.financialapp.navigation.NavItem
import com.atech.financialapp.navigation.Navigation
import com.atech.financialapp.ui.theme.FinancialAppTheme
import com.atech.financialapp.viewmodels.CategoriesViewModel
import com.atech.financialapp.viewmodels.ExpensesViewModel
import com.atech.financialapp.viewmodels.IncomesViewModel

val expensesViewModel = ExpensesViewModel()
val incomesViewModel = IncomesViewModel()
val categoriesViewModel = CategoriesViewModel()

@Composable
fun App() {
    FinancialAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {

            val navController = rememberNavController()

            // Получаем текущее состояние экрана в стеке навигации
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val destination = navBackStackEntry?.destination

            val currentItem = NavItem.barItems.firstOrNull { item ->
                destination?.hierarchy?.any {
                    it.hasRoute(item.route::class)
                } == true
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopBar(selected = currentItem)
                },
                bottomBar = {
                    BottomBar(
                        selected = currentItem,
                        navHostController = navController
                    )
                },
                contentWindowInsets = WindowInsets.ime,
            ) { innerPadding ->
                Navigation(
                    navHostController = navController,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    expenses = expensesViewModel.expenses,
                    incomes = incomesViewModel.incomes,
                    categories = categoriesViewModel.items
                )
                /** TODO Наверно View model можно просто пихнуть в Navigation**/
            }
        }
    }
}