package com.example.coinapp.common

sealed class Resource<T>(val errorType: AppErrorType?, val data: T?) {
    class Loading<T>() : Resource<T>(null, null)
    class Error<T>(errorType: AppErrorType) :Resource<T>(errorType = errorType, data = null)
    class Success<T>(data : T): Resource<T>(errorType = null, data = data)
}