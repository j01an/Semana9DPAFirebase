package com.example.semana9dpafirebase.model

data class PokemonModelDetails(
    val name: String,
    val sprites: Sprites,
    val abilities: List<AbilityModel>
)
