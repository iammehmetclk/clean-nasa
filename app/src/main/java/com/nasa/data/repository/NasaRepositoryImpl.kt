package com.nasa.data.repository

import com.nasa.data.mapper.toContentList
import com.nasa.data.remote.NasaApi
import com.nasa.domain.model.Content
import com.nasa.domain.repository.NasaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.nasa.domain.model.Result

class NasaRepositoryImpl @Inject constructor(private val api: NasaApi) : NasaRepository {

    override suspend fun getCuriosity(sol: Int, page: Int): Flow<Result<List<Content>>> {
        return flow {
            emit(Result.Loading(null, "Please wait while note is being deleted."))
            try {
                val response = api.getCuriosity(sol, page)
                emit(Result.Success(response.toContentList(), "Api responded successfully."))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(null, "Something went wrong!"))
            }
        }
    }

    override suspend fun getOpportunity(sol: Int, page: Int): Flow<Result<List<Content>>> {
        return flow {
            emit(Result.Loading(null, "Please wait while note is being deleted."))
            try {
                val response = api.getOpportunity(sol, page)
                emit(Result.Success(response.toContentList(), "Api responded successfully."))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(null, "Something went wrong!"))
            }
        }
    }

    override suspend fun getSpirit(sol: Int, page: Int): Flow<Result<List<Content>>> {
        return flow {
            emit(Result.Loading(null, "Please wait while note is being deleted."))
            try {
                val response = api.getSpirit(sol, page)
                emit(Result.Success(response.toContentList(), "Api responded successfully."))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Result.Error(null, "Something went wrong!"))
            }
        }
    }

}