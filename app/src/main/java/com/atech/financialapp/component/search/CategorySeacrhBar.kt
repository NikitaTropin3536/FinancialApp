package com.atech.financialapp.component.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.atech.financialapp.R
import com.atech.financialapp.ui.theme.FinancialAppTheme

@Preview(showBackground = true)
@Composable
fun CategorySearchBarPreview() {
    FinancialAppTheme {
        CategorySearchBar()
    }
}

@Composable
fun CategorySearchBar() {

    Row(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.primaryContainer
            )
            .fillMaxWidth()
            .defaultMinSize(minHeight = 56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Найти статью",
            modifier = Modifier.weight(1F),
            color = MaterialTheme.colorScheme.surfaceContainer,
            style = MaterialTheme.typography.bodyLarge
        )

        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.surfaceContainer
        )

    }

}