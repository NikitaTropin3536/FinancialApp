package com.atech.financialapp.component.others

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.atech.financialapp.ui.theme.FinancialAppTheme

@Preview(showBackground = true)
@Composable
private fun ThemeSwitchPreview() {
    FinancialAppTheme {
        ThemeSwitch()
    }
}

@Composable
fun ThemeSwitch(
    darkThemeChecked: Boolean = false,
    onDarkThemeCheckedChange: (Boolean) -> Unit = {},
) {

    Switch(
        checked = darkThemeChecked,
        onCheckedChange = {
            onDarkThemeCheckedChange(it)
        },

//        thumbContent = if (darkThemeChecked) {
//            {
//                Icon(
//                    imageVector = Icons.Filled.Check,
//                    contentDescription = null,
//                    modifier = Modifier.size(SwitchDefaults.IconSize),
//                )
//            }
//        } else {
//            null
//        },

        colors = SwitchDefaults.colors(
            uncheckedThumbColor = MaterialTheme.colorScheme.surfaceContainer,
            uncheckedTrackColor = MaterialTheme.colorScheme.surfaceDim,
            uncheckedBorderColor = MaterialTheme.colorScheme.surfaceContainer
        )

    )

}