package com.example.superheroes.presentation.main

import com.example.superheroes.domain.use_case.GetSuperheroUseCase
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getSuperheroUseCase: GetSuperheroUseCase
) {
    init {

    }

    fun getSuperhero(){
        getSuperheroUseCase().onEach { result ->

        }
    }
}