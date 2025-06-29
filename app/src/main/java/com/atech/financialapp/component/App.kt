package com.atech.financialapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.atech.financialapp.component.nav.BottomBar
import com.atech.financialapp.navigation.Navigation
import com.atech.financialapp.ui.theme.FinancialAppTheme

@Composable
fun App() {
    FinancialAppTheme {

        val navController = rememberNavController()

        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                contentWindowInsets = WindowInsets.ime,
                bottomBar = {
                    BottomBar(navController)
                },
            ) { innerPadding ->
                Navigation(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    navHostController = navController
                )
            }
        }
    }
}