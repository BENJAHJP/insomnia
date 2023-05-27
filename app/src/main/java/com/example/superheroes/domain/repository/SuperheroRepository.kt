package com.example.superheroes.domain.repository

import com.example.superheroes.data.dto.Superhero

interface SuperheroRepository {
    suspend fun getSuperhero(id: Int): Superhero
}