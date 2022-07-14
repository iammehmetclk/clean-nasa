package com.nasa.domain.repository

import com.nasa.domain.model.Result
import com.nasa.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface NasaRepository {

    suspend fun getCuriosity(sol: Int, page: Int) : Flow<Result<List<Content>>>

    suspend fun getOpportunity(sol: Int, page: Int) : Flow<Result<List<Content>>>

    suspend fun getSpirit(sol: Int, page: Int) : Flow<Result<List<Content>>>

}