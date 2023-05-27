package com.example.superheroes.data.dto

data class Superhero(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: Int,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val response: String,
    val work: Work
)