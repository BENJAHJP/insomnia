package com.example.superheroes.data.mapper

import com.example.superheroes.data.dto.Superhero
import com.example.superheroes.domain.model.SuperheroModel

fun Superhero.toSuperHeroModel(): SuperheroModel{
    return SuperheroModel(
        appearance, biography, connections, id, image, name, powerstats, work
    )
}