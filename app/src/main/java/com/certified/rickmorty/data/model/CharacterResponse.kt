package com.certified.rickmorty.data.model

data class CharacterResponse(
    val info: Info = Info(),
    val results: List<Character> = emptyList()
)

data class Info(
    val count: Int = 0,
    val pages: Int = 0,
    val next: String? = "",
    val prev: String? = ""
)