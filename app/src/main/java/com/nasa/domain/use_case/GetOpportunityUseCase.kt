package com.nasa.domain.use_case

import com.nasa.domain.model.Result
import com.nasa.domain.model.Content
import com.nasa.domain.repository.NasaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOpportunityUseCase @Inject constructor(private val repository: NasaRepository) {

    suspend operator fun invoke(sol: Int, page: Int): Flow<Result<List<Content>>> {
        return repository.getOpportunity(sol, page)
    }

}