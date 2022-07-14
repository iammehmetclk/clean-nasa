package com.nasa.domain.model

sealed class Result<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T?, message: String?): Result<T>(data, message)
    class Success<T>(data: T?, message: String?): Result<T>(data, message)
    class Error<T>(data: T?, message: String?): Result<T>(data, message)
}