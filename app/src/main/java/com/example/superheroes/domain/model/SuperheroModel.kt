package com.example.superheroes.domain.model

import com.example.superheroes.data.dto.Appearance
import com.example.superheroes.data.dto.Biography
import com.example.superheroes.data.dto.Connections
import com.example.superheroes.data.dto.Image
import com.example.superheroes.data.dto.Powerstats
import com.example.superheroes.data.dto.Work

data class SuperheroModel (
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: Int,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val work: Work
)