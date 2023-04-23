package com.example.meditation_app.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.meditation_app.ui.theme.theme.Black
import com.example.meditation_app.ui.theme.theme.Green
import com.example.meditation_app.ui.theme.theme.Yellow

val FILTER_CONTENT_LIST = listOf(
    FilterContent(Black, Color.White, "Mood swings"),
    FilterContent(Black, Color.White, "Stress"),
    FilterContent(Black, Color.White, "Depression"),
    FilterContent(Black, Color.White, "Anxiety"),
    FilterContent(Black, Color.White, "Anger"),
    FilterContent(Black, Color.White, "Excitement"),
    FilterContent(Black, Color.White, "Fear"),
    FilterContent(Black, Color.White, "Joy"),
    FilterContent(Black, Color.White, "Horror")
)

val MEDITATION_TYPE_LIST = listOf(
    MeditationType(
        "45 mins",
        "James Madchen",
        "Love-kind meditation",
        "During loving kindness meditation, you focus benevolent and loving energy toward yourself and others.",
        Yellow,
        Black,
        Green
    ),
    MeditationType(
        "34 mins",
        "Kate Landon",
        "Flower meditation",
        "Outdoor concentration meditation, the object is a flower.",
        Green,
        Black,
        Yellow
    ),
    MeditationType(
        "25 mins",
        "David Wilson",
        "Breather",
        "A 5-minute intro to meditation, relax and inhale to start.",
        Black,
        Color.White,
        Yellow
    ),
    MeditationType(
        "45 mins",
        "James Madchen",
        "Love-kind meditation",
        "During loving kindness meditation, you focus benevolent and loving energy toward yourself and others.",
        Yellow,
        Black,
        Green
    ),
    MeditationType(
        "34 mins",
        "Kate Landon",
        "Flower meditation",
        "Outdoor concentration meditation, the object is a flower.",
        Green,
        Black,
        Yellow
    ),
    MeditationType(
        "25 mins",
        "David Wilson",
        "Breather",
        "A 5-minute intro to meditation, relax and inhale to start.",
        Black,
        Color.White,
        Yellow
    )
)