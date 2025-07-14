package com.atech.financialapp.domain

data class Category(
    val id: Int,
    val name: String,
    val emoji: String,
    val isIncome: Boolean
)