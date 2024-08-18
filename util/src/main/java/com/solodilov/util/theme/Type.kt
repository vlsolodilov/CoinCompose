package com.solodilov.util.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.solodilov.util.R

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 20.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = 16.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_medium)),
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_regular)),
        fontSize = 14.sp,
    ),
)