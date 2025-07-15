package com.atech.financialapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.component.others.CategorySearchBar
import com.atech.financialapp.viewmodels.CategoriesViewModel

@Composable
fun CategoriesScreen(
    categoriesVM: CategoriesViewModel = viewModel()
) {

    Column(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.onSurface
        )
    ) {

        CategorySearchBar()

        HorizontalDivider(
            color = MaterialTheme.colorScheme.surfaceDim,
            thickness = 1.dp
        )

        LazyColumn(
            contentPadding = PaddingValues(1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            items(
                items = categoriesVM.items,
                key = { item -> item.id }
            ) { item ->

                ColumnItem(
                    title = item.name,
                    emoji = item.emoji,
                    highEmphasis = true,
                )

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.surfaceDim,
                    thickness = 1.dp
                )

            }

        }

    }

}