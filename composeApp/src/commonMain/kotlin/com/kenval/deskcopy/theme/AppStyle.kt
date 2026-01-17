package com.kenval.deskcopy.theme

import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import deskcopy.composeapp.generated.resources.CyberformDemo
import deskcopy.composeapp.generated.resources.DisposableDroidBB
import deskcopy.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

object AppStyle {

    object Colors {
        val background = Color(0xff00374b)
        val content = Color(0xffffffff)
        val unfocusedBorder = Color(0xff0f96c7)
        val focusedBorder = Color(0xff0fb5f1)
        val darkText = Color(0xff0a0a0a)
    }

}

@Composable
fun primaryTextFieldColors() = OutlinedTextFieldDefaults.colors(
    unfocusedBorderColor = AppStyle.Colors.unfocusedBorder,
    focusedBorderColor = AppStyle.Colors.focusedBorder,
    disabledBorderColor = AppStyle.Colors.focusedBorder,
    cursorColor = AppStyle.Colors.unfocusedBorder,
    selectionColors = TextSelectionColors(
        handleColor = AppStyle.Colors.focusedBorder,
        backgroundColor = AppStyle.Colors.focusedBorder.copy(alpha = 0.4f)
    ),
    unfocusedTextColor = AppStyle.Colors.content,
    focusedTextColor = AppStyle.Colors.content,
    disabledTextColor = AppStyle.Colors.content,
    errorTextColor = AppStyle.Colors.content
)

@Composable
fun primaryButtonColors() = ButtonColors(
    containerColor = AppStyle.Colors.focusedBorder,
    contentColor = AppStyle.Colors.content,
    disabledContainerColor = AppStyle.Colors.focusedBorder.copy(alpha = 0.2f),
    disabledContentColor = AppStyle.Colors.content.copy(alpha = 0.2f)
)

@Composable
fun primaryCheckboxColors() = CheckboxColors(
    checkedCheckmarkColor = AppStyle.Colors.content,
    uncheckedCheckmarkColor = AppStyle.Colors.background,
    checkedBoxColor = AppStyle.Colors.focusedBorder,
    uncheckedBoxColor = AppStyle.Colors.background,
    checkedBorderColor = AppStyle.Colors.focusedBorder,
    uncheckedBorderColor = AppStyle.Colors.unfocusedBorder,
    disabledCheckedBoxColor = AppStyle.Colors.darkText,
    disabledUncheckedBoxColor = AppStyle.Colors.darkText,
    disabledIndeterminateBoxColor = AppStyle.Colors.darkText,
    disabledBorderColor = AppStyle.Colors.darkText,
    disabledUncheckedBorderColor = AppStyle.Colors.darkText,
    disabledIndeterminateBorderColor = AppStyle.Colors.darkText,
)

@Composable
fun mainFont() = FontFamily(Font(Res.font.DisposableDroidBB))
@Composable
fun cyberDemoFont() = FontFamily(Font(Res.font.CyberformDemo))