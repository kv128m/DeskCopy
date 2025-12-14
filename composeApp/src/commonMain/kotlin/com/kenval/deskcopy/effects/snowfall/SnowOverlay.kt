package com.kenval.deskcopy.effects.snowfall

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import com.kenval.deskcopy.theme.AppStyle
import kotlinx.coroutines.delay
import kotlin.random.Random

@Composable
fun SnowOverlay() {
    var width by remember { mutableStateOf(1000f) }
    var height by remember { mutableStateOf(1000f) }

    val snowflakes by snowEffect(
        List(100) {
            Snowflake.createSnowflake(width, height)
        },
        width,
        height
    )

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        width = size.width
        height = size.height
        snowflakes.forEach { snowflake ->
            drawCircle(
                color = AppStyle.Colors.content,
                radius = snowflake.radius,
                center = Offset(snowflake.x, snowflake.y)
            )
        }


    }
}

@Composable
private fun snowEffect(items: List<Snowflake>, width: Float, height: Float): State<List<Snowflake>> {
    return produceState(initialValue = items, width, height) {
        while (true) {
            delay(40L)
            value = value.map {
                val item = it.copy(y = it.y + it.speed, x = it.x + Random.nextFloat())
                if (item.y > height) {
                    item.copy(x = width * Random.nextFloat(), y = 0f)
                } else {
                    item
                }
            }
        }
    }
}