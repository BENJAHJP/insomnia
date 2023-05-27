package com.example.superheroes.presentation.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroes.common.Resource
import com.example.superheroes.domain.use_case.GetSuperheroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getSuperheroUseCase: GetSuperheroUseCase
) : ViewModel(){
    private val _state = mutableStateOf(MainScreenState())
    val state = _state

    init {
        getSuperhero(0)
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
        }.launchIn(viewModelScope)
    }
}