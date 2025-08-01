package com.atech.financialapp.reposiroty

import com.atech.financialapp.domain.Category

interface CategoriesRepository {

    suspend fun getAllCategories(): Result<List<Category>>

    suspend fun getCategoriesByType(isIncome: Boolean): Result<List<Category>>

}