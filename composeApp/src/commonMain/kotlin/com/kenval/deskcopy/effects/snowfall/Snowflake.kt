package com.kenval.deskcopy.effects.snowfall

import kotlin.random.Random

data class Snowflake(
    val x: Float,
    val y: Float,
    val radius: Float,
    val speed: Float
) {
    companion object {
        fun createSnowflake(canvasWidth: Float, canvasHeight: Float): Snowflake {
            val x = Random.nextFloat() * canvasWidth
            val y = Random.nextFloat() * canvasHeight
            val radius = 10f * Random.nextFloat()
            val speed = 12f * Random.nextFloat() + 5f
            return Snowflake(x, y, radius, speed)
        }
    }
}
