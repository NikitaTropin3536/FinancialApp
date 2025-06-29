package com.atech.financialapp.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.atech.financialapp.screens.AccountScreen
import com.atech.financialapp.screens.ArticlesScreen
import com.atech.financialapp.screens.ExpensesScreen
import com.atech.financialapp.screens.IncomeScreen
import com.atech.financialapp.screens.SettingsScreen
import kotlinx.serialization.Serializable

sealed interface NavGraph {

    @Serializable
    data object Expenses : NavGraph {
        fun NavGraphBuilder.expenses() {
            composable<Route.Expenses> {
                ExpensesScreen()
            }
        }
    }

    @Serializable
    data object Income : NavGraph {
        fun NavGraphBuilder.income() {
            composable<Route.Income> {
                IncomeScreen()
            }
        }
    }

    @Serializable
    data object Account : NavGraph {
        fun NavGraphBuilder.account() {
            composable<Route.Account> {
                AccountScreen()
            }
        }
    }

    @Serializable
    data object Articles : NavGraph {
        fun NavGraphBuilder.articles() {
            composable<Route.Articles> {
                ArticlesScreen()
            }
        }
    }

    @Serializable
    data object Settings : NavGraph {
        fun NavGraphBuilder.settings() {
            composable<Route.Settings> {
                SettingsScreen()
            }
        }
    }

}