package com.example.meditation_app.ui.theme

import androidx.compose.ui.graphics.Color

data class MeditationType(
    val duration: String,
    val teacher: String,
    val title: String,
    val description: String,
    val backgroundColor: Color,
    val contentColor: Color,
    val timeBackgroundColor: Color
)