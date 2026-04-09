package com.n1cks.starwarstest.core.data.mapper

fun extractIdFromUrl(url: String): String {
    return url.trimEnd('/').substringAfterLast('/')
}