package com.atech.financialapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.atech.financialapp.domain.Category
import com.atech.financialapp.domain.TransactionResponse
import com.atech.financialapp.navigation.NavGraph.Account.account
import com.atech.financialapp.navigation.NavGraph.Categories.categories
import com.atech.financialapp.navigation.NavGraph.Expenses.expenses
import com.atech.financialapp.navigation.NavGraph.Incomes.incomes
import com.atech.financialapp.navigation.NavGraph.Settings.settings

@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    expenses: List<TransactionResponse>,
    categories: List<Category>,
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Expenses,
        modifier = modifier,
    ) {
        expenses(expenses)
        incomes()
        account()
        categories(categories)
        settings()
    }
}