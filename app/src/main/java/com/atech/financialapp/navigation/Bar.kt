package com.atech.financialapp.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.atech.financialapp.R

/**
 * Все табы приложения
 * */

sealed class Bar(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: Route,
) {

    data object Expenses : Bar(
        title = R.string.expenses,
        icon = R.drawable.ic_expenses,
        route = Route.Expenses
    )

    data object Income : Bar(
        title = R.string.income,
        icon = R.drawable.ic_income,
        route = Route.Income,
    )

    data object Account : Bar(
        title = R.string.account,
        icon = R.drawable.ic_account,
        route = Route.Account,
    )

    data object Articles : Bar(
        title = R.string.articles,
        icon = R.drawable.ic_articles,
        route = Route.Articles,
    )

    data object Settings : Bar(
        title = R.string.settings,
        icon = R.drawable.ic_settings,
        route = Route.Settings,
    )

    companion object {
        val items = listOf(
            Expenses, Income,
            Account, Articles, Settings
        )
    }

}
