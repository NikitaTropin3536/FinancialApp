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
fun IncomesScreen(
    incomes: List<TransactionResponse> = emptyList()
) {
    Column(
        modifier = Modifier.background(
            Color.White
        )
    ) {

        ColumnItem(
            title = stringResource(R.string.total),
            value = "600 000 ₽",
            color = Color.White
        )
        Divider(color = MaterialTheme.colorScheme.surfaceDim)

        LazyColumn(
            contentPadding = PaddingValues(vertical = 1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            items(
                items = incomes,
                key = { income -> income.id }
            ) { income ->

                ColumnItem(
                    title = income.category.name,
                    description = income.comment ?: "",
                    value = income.amount
                            + " "
                            + Currency.getInstance(income.account.currency).symbol,
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