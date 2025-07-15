package com.atech.financialapp.screens

import android.icu.util.Currency
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.atech.financialapp.R
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.viewmodels.IncomesViewModel

@Composable
fun IncomesScreen(
    incomesVM: IncomesViewModel = viewModel()
) {

    Column(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.onSurface
        )
    ) {

        ColumnItem(
            title = stringResource(R.string.total),
            value = "600 000 ₽",
            color = MaterialTheme.colorScheme.surfaceContainerLow
        )
        HorizontalDivider(
            color = MaterialTheme.colorScheme.surfaceDim,
            thickness = 1.dp
        )

        LazyColumn(
            contentPadding = PaddingValues(vertical = 1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp)
        ) {

            items(
                items = incomesVM.incomes,
                key = { income -> income.id }
            ) { income ->

                ColumnItem(
                    title = income.category.name,
                    comment = income.comment ?: "",
                    value = income.amount
                            + " "
                            + Currency.getInstance(income.account.currency).symbol,
                    highEmphasis = true,

                    viewRight = {
                        Icon(
                            painter = painterResource(R.drawable.ic_chevron_right),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.surfaceDim
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

}