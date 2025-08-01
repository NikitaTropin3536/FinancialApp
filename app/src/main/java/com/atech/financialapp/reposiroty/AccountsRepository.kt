package com.atech.financialapp.reposiroty

import com.atech.financialapp.domain.AccountCreateRequest
import com.atech.financialapp.domain.AccountHistoryResponse
import com.atech.financialapp.domain.AccountResponse
import com.atech.financialapp.domain.AccountUpdateRequest

interface AccountsRepository {

    suspend fun getAllAccounts() : Result<List<AccountResponse>>

    suspend fun createNewAccount(accountCreateRequest: AccountCreateRequest) : Result<Unit>

    suspend fun getAccountById(id: Int) : Result<AccountResponse>

    suspend fun updateAccount(id: Int, accountUpdateRequest: AccountUpdateRequest) : Result<Unit>

    suspend fun deleteAccount(id: Int) : Result<Unit>

    suspend fun getAccountChangeHistory(id: Int): Result<AccountHistoryResponse>

}