package com.atech.financialapp.component.items

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atech.financialapp.ui.theme.FinancialAppTheme

@Preview
@Composable
private fun ColumnItemPreview() {
    FinancialAppTheme {
        ColumnItem()
    }
}

/**
 * Компонент представления чего - то
 *
 * @param title Заголовок элемента
 * @param comment Комментарий (опционально)
 * @param value Значение элемента (опционально)
 * @param emoji Символ эмодзи (опционально)
 * @param emjColor Фоновый цвет иконки
 * @param color Цвет item - а
 * @param highEmphasis Флаг на увеличение высоты блока
 * @param viewRight View справа (опционально)
 * @param onClick Обработчик события нажатия
 */
@Composable
fun ColumnItem(
    title: String = "",
    comment: String = "",
    value: String = "",
    emoji: String? = null,
    emjColor: Color = MaterialTheme.colorScheme.surfaceContainerLow,
    color: Color = MaterialTheme.colorScheme.onSurface,
    highEmphasis: Boolean = false,
    viewRight: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .background(color)
            .fillMaxWidth()
            .defaultMinSize(
                minHeight = (if (highEmphasis) 68 else 56).dp
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        emoji?.let {

            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .background(emjColor),
                contentAlignment = Alignment.Center
            ) {

                BasicText(

                    text = emoji,

                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.inverseOnSurface
                    ),

                    autoSize = TextAutoSize.StepBased(
                        minFontSize = with(LocalDensity.current) { 8.dp.toSp() },
                        maxFontSize = with(LocalDensity.current) { 12.dp.toSp() },
                        stepSize = with(LocalDensity.current) { 2.dp.toSp() }
                    )

                )

            }

        }

        Column(
            modifier = Modifier.weight(1F)
        ) {

            Text(
                text = title,
                color = MaterialTheme.colorScheme.inverseOnSurface,
                style = MaterialTheme.typography.bodyLarge
            )

            if (comment.isNotBlank()) {
                Text(
                    text = comment,
                    color = MaterialTheme.colorScheme.surfaceContainer,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 12.sp
                )
            }

        }

        if (value.isNotBlank()) {
            Text(
                text = value,
                color = MaterialTheme.colorScheme.inverseOnSurface,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.End
            )
        }

        viewRight?.invoke()

    }

}
