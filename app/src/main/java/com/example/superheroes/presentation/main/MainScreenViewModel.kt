package com.example.superheroes.presentation.main

import androidx.compose.runtime.mutableStateOf
import com.example.superheroes.common.Resource
import com.example.superheroes.domain.use_case.GetSuperheroUseCase
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val getSuperheroUseCase: GetSuperheroUseCase
) {
    private val _state = mutableStateOf(MainScreenState())
    val state = _state

    init {
        getSuperhero(1)
    }

    fun getSuperhero(id: Int){
        getSuperheroUseCase(id).onEach { result ->
            when(result){
                is Resource.Error -> {
                    _state.value = MainScreenState(message = result.message ?: "Unknown error occurred")
                }
                is Resource.Loading -> {
                    _state.value = MainScreenState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = MainScreenState(superhero = result.data)
                }
            }
        }
    }
}