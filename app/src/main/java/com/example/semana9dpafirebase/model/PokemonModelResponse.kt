package com.example.semana9dpafirebase.model

data class PokemonModelResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonModel>
)
