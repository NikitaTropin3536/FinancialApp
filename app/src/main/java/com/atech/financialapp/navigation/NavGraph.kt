package com.atech.financialapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.atech.financialapp.domain.Category
import com.atech.financialapp.domain.TransactionResponse
import com.atech.financialapp.screens.AccountScreen
import com.atech.financialapp.screens.CategoriesScreen
import com.atech.financialapp.screens.ExpensesScreen
import com.atech.financialapp.screens.IncomesScreen
import com.atech.financialapp.screens.SettingsScreen

sealed interface NavGraph {

    data object Expenses : NavGraph {
        fun NavGraphBuilder.expenses(expenses: List<TransactionResponse>) {
            composable<Route.Expenses> {
                ExpensesScreen(expenses)
            }
        }
    }

    data object Incomes : NavGraph {
        fun NavGraphBuilder.incomes(incomes: List<TransactionResponse>) {
            composable<Route.Incomes> {
                IncomesScreen(incomes)
            }
        }
    }

    data object Account : NavGraph {
        fun NavGraphBuilder.account() {
            composable<Route.Account> {
                AccountScreen()
            }
        }
    }

    data object Categories : NavGraph {
        fun NavGraphBuilder.categories(categories: List<Category>) {
            composable<Route.Categories> {
                CategoriesScreen(categories)
            }
        }
    }

    data object Settings : NavGraph {
        fun NavGraphBuilder.settings() {
            composable<Route.Settings> {
                SettingsScreen()
            }
        }
    }

}