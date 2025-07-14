package com.atech.financialapp.navigation

import kotlinx.serialization.Serializable

/**
 * Интерфейс для всех навигаций
 * */

sealed interface Route {

    @Serializable
    data object Expenses : Route

    @Serializable
    data object Incomes : Route

    @Serializable
    data object Account : Route

    @Serializable
    data object Categories : Route

    @Serializable
    data object Settings : Route

}