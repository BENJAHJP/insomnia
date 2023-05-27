package com.example.superheroes.presentation.main

import com.example.superheroes.domain.model.SuperheroModel

data class MainScreenState(
    val isLoading: Boolean = false,
    val message: String = "",
    val superhero: SuperheroModel? = null
)