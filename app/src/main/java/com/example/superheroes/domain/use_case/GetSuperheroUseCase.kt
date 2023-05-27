package com.example.superheroes.domain.use_case

import com.example.superheroes.common.Resource
import com.example.superheroes.data.dto.Superhero
import com.example.superheroes.data.mapper.toSuperHeroModel
import com.example.superheroes.domain.model.SuperheroModel
import com.example.superheroes.domain.repository.SuperheroRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSuperheroUseCase @Inject constructor(
    private val superheroRepository: SuperheroRepository
) {
    operator fun invoke(id: Int): Flow<Resource<SuperheroModel>> = flow {
        try {
            emit(Resource.Loading())
            val superhero = superheroRepository.getSuperhero(id).toSuperHeroModel()
            emit(Resource.Success(superhero))
        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unknown error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("Check your internet connection"))
        }
    }
}