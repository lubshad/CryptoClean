package com.example.cryptomvvm.common

import com.example.cryptomvvm.data.model.AppErrorType

sealed class Resource<T>(val data: T?= null, val error: AppErrorType? = null) {
    class Loading<T> : Resource<T>()
    class Error<T>(error: AppErrorType) : Resource<T>(data = null, error)
    class Success<T>(data: T) : Resource<T>(data)
}
