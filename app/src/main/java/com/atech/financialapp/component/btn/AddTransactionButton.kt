package com.atech.financialapp.component.btn

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atech.financialapp.R
import com.atech.financialapp.ui.theme.FinancialAppTheme

@Preview
@Composable
fun AddTransactionButtonPreview() {
    FinancialAppTheme {
        AddTransactionButton()
    }
}

@Composable
fun AddTransactionButton() {

    FloatingActionButton(
        onClick = { },
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.surface,
        elevation = FloatingActionButtonDefaults.elevation(
            0.dp, 0.dp, 0.dp, 0.dp
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_add),
            contentDescription = null
        )
    }

}