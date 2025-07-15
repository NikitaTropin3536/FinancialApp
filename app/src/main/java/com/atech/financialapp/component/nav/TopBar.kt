package com.atech.financialapp.component.nav

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.atech.financialapp.R
import com.atech.financialapp.navigation.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    selected: NavItem?
) {

    CenterAlignedTopAppBar(

        title = {
            Text(
                text = stringResource(id = (selected?.title ?: R.string.unKnown)),
                style = MaterialTheme.typography.titleLarge
            )
        },

        navigationIcon = {},

        actions = {

            IconButton(
                onClick = { }
            ) {

                Icon(
                    painter = painterResource(
                        when (selected) {
                            is NavItem.Expenses, is NavItem.Incomes -> R.drawable.ic_mdi_history
                            is NavItem.Account -> R.drawable.ic_edit
                            else -> R.drawable.ic_chevron_right
                        }
                    ),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surfaceContainer
                )

            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.inverseOnSurface
        )

    )

}