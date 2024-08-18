package com.solodilov.coin.screen.coin_list.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.solodilov.domain.entity.Currency

@Composable
fun CurrencyChip(
    currency: Currency,
    isSelected: Boolean,
    onSelected: (Currency) -> Unit,
) {
    Surface(
        modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = { onSelected(currency) }
            ),
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) {
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.12f)
        } else {
            MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.12f)
        },
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 8.dp),
            text = currency.name.uppercase(),
            style = MaterialTheme.typography.labelMedium,
            color = if (isSelected) {
                MaterialTheme.colorScheme.secondary
            } else {
                MaterialTheme.colorScheme.onBackground
            }
        )
    }
}