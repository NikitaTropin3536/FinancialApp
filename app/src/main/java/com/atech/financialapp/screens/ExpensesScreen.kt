package com.atech.financialapp.screens

import android.icu.util.Currency
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.atech.financialapp.R
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.domain.TransactionResponse

@Composable
fun ExpensesScreen(
    expenses: List<TransactionResponse> = emptyList()
) {
    Column(
        modifier = Modifier.background(
            Color.White
        )
    ) {

        ColumnItem(
            title = stringResource(R.string.total),
            value = "800 000 ₽",
            color = MaterialTheme.colorScheme.surfaceContainerLow
        )
        Divider(color = MaterialTheme.colorScheme.surfaceDim)

        LazyColumn(
            contentPadding = PaddingValues(vertical = 1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            items(
                items = expenses,
                key = { expense -> expense.id }
            ) { expense ->

                ColumnItem(
                    title = expense.category.name,
                    description = expense.comment ?: "",
                    value = expense.amount
                            + " "
                            + Currency.getInstance(expense.account.currency).symbol,
                    emoji = expense.category.emoji,
                    color = Color.White,
                    highEmphasis = true,

                    viewRight = {
                        Icon(
                            painter = painterResource(R.drawable.ic_chevron_right),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondaryContainer
                        )
                    }
                )
                Divider(color = MaterialTheme.colorScheme.surfaceDim)

            }

        }

    }
}