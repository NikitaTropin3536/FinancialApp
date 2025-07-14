package com.atech.financialapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atech.financialapp.R
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.component.others.ThemeSwitch
import com.atech.financialapp.ui.theme.FinancialAppTheme

val settingsItems = listOf(
    "Основной цвет",
    "Звуки",
    "Хаптики",
    "Код пароль",
    "Cинхронизация",
    "Язык",
    "О программе"
)

@Preview(showBackground = true)
@Composable
private fun SettingsScreenPreview() {
    FinancialAppTheme {
        SettingsScreen()
    }
}

@Composable
fun SettingsScreen() {

    LazyColumn(
        modifier = Modifier.background(
            Color.White
        ),
        contentPadding = PaddingValues(bottom = 1.dp),  // Нижний внутренний отступ
        verticalArrangement = Arrangement.spacedBy(1.dp)// Пространство между элементами списка
    ) {

        item {

            ColumnItem(
                title = "Тёмная тема",
                color = Color.White,
                viewRight = { ThemeSwitch() }
            )
            Divider(color = MaterialTheme.colorScheme.surfaceDim)

        }

        items(settingsItems) { item ->

            ColumnItem(
                title = item,
                color = Color.White,
                viewRight = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceContainer
                    )
                }
            )
            Divider(color = MaterialTheme.colorScheme.surfaceDim)

        }

    }

}