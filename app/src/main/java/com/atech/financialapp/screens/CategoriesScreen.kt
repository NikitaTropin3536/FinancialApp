package com.atech.financialapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.component.search.CategorySearchBar
import com.atech.financialapp.domain.Category

@Composable
fun CategoriesScreen(
    items: List<Category> = emptyList()
) {

    Column(
        modifier = Modifier.background(
            Color.White
        )
    ) {

        CategorySearchBar()

        LazyColumn(
            contentPadding = PaddingValues(1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            items (
                items = items,
                key = { item -> item.id }
            ) { item ->

                ColumnItem(
                    title = item.name,
                    emoji = item.emoji,
                    highEmphasis = true,
                )

            }

        }

    }

}