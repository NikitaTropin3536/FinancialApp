package com.atech.financialapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.atech.financialapp.screens.AccountScreen
import com.atech.financialapp.screens.ArticlesScreen
import com.atech.financialapp.screens.ExpensesScreen
import com.atech.financialapp.screens.IncomeScreen
import com.atech.financialapp.screens.SettingsScreen
import com.atech.financialapp.ui.theme.FinancialAppTheme

sealed interface NavGraph {

    data object Expenses : NavGraph {
        fun NavGraphBuilder.expenses() {
            composable<Route.Expenses> {
                ExpensesScreen()
            }
        }
    }

    data object Income : NavGraph {
        fun NavGraphBuilder.income() {
            composable<Route.Income> {
                IncomeScreen()
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

    data object Articles : NavGraph {
        fun NavGraphBuilder.articles() {
            composable<Route.Articles> {
                ArticlesScreen()
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