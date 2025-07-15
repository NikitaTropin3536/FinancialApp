package com.atech.financialapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atech.financialapp.R
import com.atech.financialapp.component.items.ColumnItem
import com.atech.financialapp.ui.theme.FinancialAppTheme


@Preview(showBackground = true)
@Composable
private fun AccountScreenPreview() {
    FinancialAppTheme {
        AccountScreen()
    }
}

@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier.background(
            MaterialTheme.colorScheme.onSurface
        ),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {

        ColumnItem(
            title = stringResource(R.string.balance),
            value = "-600 000 ₽",
            emoji = "\uD83D\uDCB0",
            emjColor = MaterialTheme.colorScheme.onSurface,
            color = MaterialTheme.colorScheme.surfaceContainerLow,

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

        ColumnItem(
            title = stringResource(R.string.currency),
            value = "₽",
            color = MaterialTheme.colorScheme.surfaceContainerLow,

            viewRight = {
                Icon(
                    painter = painterResource(R.drawable.ic_chevron_right),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surfaceDim
                )
            }

        )

    }

}