package com.atech.financialapp.navigation

import com.atech.financialapp.R

/**
 * Все табы приложения
 * */

val navBarItems = listOf(
    NavItem(
        title = R.string.expenses,
        icon = R.drawable.ic_expenses,
        route = Route.Expenses
    ),
    NavItem(
        title = R.string.income,
        icon = R.drawable.ic_income,
        route = Route.Income,
    ),
    NavItem(
        title = R.string.account,
        icon = R.drawable.ic_account,
        route = Route.Account,
    ),

    NavItem(
        title = R.string.articles,
        icon = R.drawable.ic_articles,
        route = Route.Articles,
    ),

    NavItem(
        title = R.string.settings,
        icon = R.drawable.ic_settings,
        route = Route.Settings,
    )
)
