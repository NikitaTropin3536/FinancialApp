package com.atech.financialapp.component.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.atech.financialapp.navigation.NavGraph.Account.account
import com.atech.financialapp.navigation.NavGraph.Categories.categories
import com.atech.financialapp.navigation.NavGraph.Expenses.expenses
import com.atech.financialapp.navigation.NavGraph.Incomes.incomes
import com.atech.financialapp.navigation.NavGraph.Settings.settings
import com.atech.financialapp.navigation.Route

@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(
        navController = navHostController,
        startDestination = Route.Expenses,
        modifier = modifier,
    ) {

        expenses()
        incomes()
        account()
        categories()
        settings()

    }

}