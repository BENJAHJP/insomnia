package com.example.superheroes.data.api

import com.example.superheroes.data.dto.Superhero
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("{id}")
    suspend fun getSuperhero(
        @Path("id") id: Int
    ): Superhero
}