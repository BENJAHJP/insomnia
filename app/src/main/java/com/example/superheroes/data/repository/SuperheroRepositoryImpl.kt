package com.example.superheroes.data.repository

import com.example.superheroes.data.api.Api
import com.example.superheroes.data.dto.Superhero
import com.example.superheroes.domain.repository.SuperheroRepository
import javax.inject.Inject

class SuperheroRepositoryImpl @Inject constructor(
    private val api: Api
): SuperheroRepository {
    override suspend fun getSuperhero(id: Int): Superhero {
        return api.getSuperhero(id)
    }
}