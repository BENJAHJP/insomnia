package com.example.superheroes.data.dto

data class Appearance(
    val `eye-color`: String,
    val gender: String,
    val `hair-color`: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)