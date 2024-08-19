package com.solodilov.coin.screen.coin_detail.ui

import android.text.Spanned
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import com.solodilov.util.R

@Composable
fun HtmlText(html: String, modifier: Modifier = Modifier) {
    val spanned: Spanned = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    val annotatedString = buildAnnotatedString {
        val text = spanned.toString()
        append(text)

        addStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular))
            ),
            start = 0,
            end = text.length
        )
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->

        }
    )
}