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

    data object Incomes : NavItem(
        title = R.string.incomes,
        icon = R.drawable.ic_incomes,
        route = Route.Incomes,
    )

    data object Account : NavItem(
        title = R.string.account,
        icon = R.drawable.ic_account,
        route = Route.Account,
    )

    data object Categories : NavItem(
        title = R.string.categories,
        icon = R.drawable.ic_categories,
        route = Route.Categories,
    )

    data object Settings : NavItem(
        title = R.string.settings,
        icon = R.drawable.ic_settings,
        route = Route.Settings,
    )

    companion object {
        val barItems = listOf(
            Expenses, Incomes,
            Account, Categories,
            Settings
        )
    }

}