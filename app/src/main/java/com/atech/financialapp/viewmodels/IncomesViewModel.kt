package com.atech.financialapp.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.atech.financialapp.domain.AccountBrief
import com.atech.financialapp.domain.Category
import com.atech.financialapp.domain.TransactionResponse

class IncomesViewModel : ViewModel() {

    val incomes = mutableStateListOf(

        TransactionResponse(
            id = 9,

            account = AccountBrief(
                id = 0,
                name = "Account",
                balance = "100 000",
                currency = "RUB",
            ),

            category = Category(
                id = 7,
                name = "Зарплата",
                emoji = "",
                isIncome = true,
            ),

            amount = "500 000",
            transactionDate = "2025-06-13T10:22:43.162Z",
            comment = null,
            createdAt = "2025-06-13T10:22:49.297433Z",
            updatedAt = "2025-06-13T10:22:49.297433Z",
        ),

        TransactionResponse(
            id = 10,

            account = AccountBrief(
                id = 0,
                name = "Account",
                balance = "100 000",
                currency = "RUB",
            ),

            category = Category(
                id = 8,
                name = "Подработка",
                emoji = "",
                isIncome = true,
            ),

            amount = "100 000",
            transactionDate = "2025-06-13T10:22:43.162Z",
            comment = null,
            createdAt = "2025-06-13T10:22:49.297433Z",
            updatedAt = "2025-06-13T10:22:49.297433Z",
        ),

    )

    val total = ""
}