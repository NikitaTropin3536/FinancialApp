package com.atech.financialapp.component.nav

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
import com.atech.financialapp.navigation.Route
import com.atech.financialapp.viewmodels.SettingsViewModel

@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    expenses: List<TransactionResponse>,
    incomes: List<TransactionResponse>,
    categories: List<Category>,
    settingsViewModel: SettingsViewModel
) {

    NavHost(
        navController = navHostController,
        startDestination = Route.Expenses,
        modifier = modifier,
    ) {

        expenses(expenses)
        incomes(incomes)
        account()
        categories(categories)
        settings(settingsViewModel)

    }

}