package com.atech.financialapp.reposiroty

import com.atech.financialapp.domain.TransactionRequest
import com.atech.financialapp.domain.TransactionResponse

interface TransactionsRepository {

    suspend fun createTransaction(transactionRequest: TransactionRequest): Result<Unit>

    suspend fun getTransactionById(id: Int): Result<TransactionResponse>

    suspend fun updateTransaction(id: Int): Result<Unit>

    suspend fun deleteTransaction(id: Int): Result<Unit>

    suspend fun getTransactionsForPeriod(
        accountId: Int,
        startDate: String,
        endDate: String
    ): Result<List<TransactionResponse>>
}