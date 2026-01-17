package com.kenval.deskcopy.extensions

fun String.validateUrl(condition: Boolean = true, block: (String) -> Unit) {
    if (isNotBlank() && condition) {
        if (!startsWith("https://")) {
            val url = "https://$this".replace(" ", "")
            block(url)
        }
    }
}