package com.atech.financialapp.navigation

import com.atech.financialapp.R

/**
 * Все табы приложения
 * */

sealed class NavItem(
    val title: Int,
    val icon: Int,
    val route: Route
) {

    data object Expenses : NavItem(
        title = R.string.expenses,
        icon = R.drawable.ic_expenses,
        route = Route.Expenses
    )

    data object Income : NavItem(
        title = R.string.income,
        icon = R.drawable.ic_income,
        route = Route.Income,
    )

    data object Account : NavItem(
        title = R.string.account,
        icon = R.drawable.ic_account,
        route = Route.Account,
    )

    data object Articles : NavItem(
        title = R.string.articles,
        icon = R.drawable.ic_articles,
        route = Route.Articles,
    )

    data object Settings : NavItem(
        title = R.string.settings,
        icon = R.drawable.ic_settings,
        route = Route.Settings,
    )

    companion object {
        val barItems = listOf(
            Expenses, Income,
            Account, Articles,
            Settings
        )
    }
}