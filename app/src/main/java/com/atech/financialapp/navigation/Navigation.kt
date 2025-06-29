package com.atech.financialapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.atech.financialapp.navigation.NavGraph.Account.account
import com.atech.financialapp.navigation.NavGraph.Articles.articles
import com.atech.financialapp.navigation.NavGraph.Expenses.expenses
import com.atech.financialapp.navigation.NavGraph.Income.income
import com.atech.financialapp.navigation.NavGraph.Settings.settings

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Expenses,
        modifier = modifier,
    ) {
        expenses()
        income()
        account()
        articles()
        settings()
    }
}