package com.example.mvvmclean.utils

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

object ColorUtil {
    private val colors = listOf(
        Color.parseColor("#56CCF2"), // Soft Blue
        Color.parseColor("#BB6BD9"), // Light Purple
        Color.parseColor("#FF6B6B"), // Bright Coral
        Color.parseColor("#6FCF97"), // Fresh Mint
        Color.parseColor("#F2994A"), // Warm Orange
        Color.parseColor("#F2C94C"), // Golden Yellow
        Color.parseColor("#1ABC9C"), // Teal Blue
        Color.parseColor("#E056FD"), // Rose Pink
        Color.parseColor("#95A5A6"), // Sky Gray
        Color.parseColor("#C0392B")  // Rich Burgundy
    )

    /**
     * Create a gradient drawable with two distinct random colors.
     *
     * @return A GradientDrawable with a random gradient.
     */
    fun createRandomGradient(): GradientDrawable {
        val startColor = colors.random()
        var endColor = colors.random()

        // Ensure startColor and endColor are not the same
        while (endColor == startColor) {
            endColor = colors.random()
        }

        return GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT, // Gradient orientation
            intArrayOf(startColor, endColor)
        ).apply {
            gradientType = GradientDrawable.LINEAR_GRADIENT
        }
    }
}
