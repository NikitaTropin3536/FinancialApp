package com.atech.financialapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.atech.financialapp.R
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.component.others.ThemeSwitch
import com.atech.financialapp.viewmodels.SettingsViewModel

val settingsItems = listOf(
    "Основной цвет",
    "Звуки",
    "Хаптики",
    "Код пароль",
    "Cинхронизация",
    "Язык",
    "О программе"
)

@Composable
fun SettingsScreen(
    setVM: SettingsViewModel
) {

    LazyColumn(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.onSurface
        ),
        contentPadding = PaddingValues(bottom = 1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {

        item {

            ColumnItem(
                title = "Тёмная тема",
                viewRight = {
                    ThemeSwitch(
                        darkThemeChecked = setVM.darkThemeChecked.value,
                        onDarkThemeCheckedChange = setVM::onDarkThemeCheckedChange
                    )
                }
            )

            HorizontalDivider(
                color = MaterialTheme.colorScheme.surfaceDim,
                thickness = 1.dp
            )

        }

        items(settingsItems) { item ->

            ColumnItem(
                title = item,
                viewRight = {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceContainer
                    )
                }
            )

            HorizontalDivider(
                color = MaterialTheme.colorScheme.surfaceDim,
                thickness = 1.dp
            )

        }

    }

}