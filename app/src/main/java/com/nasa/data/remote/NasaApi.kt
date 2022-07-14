package com.nasa.data.remote

import com.nasa.ApplicationConstant
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("curiosity/photos?")
    suspend fun getCuriosity(
        @Query("sol") sol: Int = 1,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApplicationConstant.API_KEY,
        @Query("camera") camera: String? = null
    ): NasaResponse

    @GET("opportunity/photos?")
    suspend fun getOpportunity(
        @Query("sol") sol: Int = 1,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApplicationConstant.API_KEY,
        @Query("camera") camera: String? = null
    ): NasaResponse

    @GET("spirit/photos?")
    suspend fun getSpirit(
        @Query("sol") sol: Int = 1,
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String = ApplicationConstant.API_KEY,
        @Query("camera") camera: String? = null
    ): NasaResponse

}