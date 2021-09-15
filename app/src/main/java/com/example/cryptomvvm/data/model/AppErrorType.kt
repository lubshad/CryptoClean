package com.example.cryptomvvm.data.model

sealed class AppErrorType(val errorMessage: String? = null) {
    class NetworkError(errorMessage: String?) : AppErrorType(errorMessage = errorMessage)
    class ServerError(errorMessage: String?) : AppErrorType(errorMessage = errorMessage)
    class UnexpectedError(errorMessage: String?) : AppErrorType(errorMessage = errorMessage)


    fun getMessage() : String {
        val message = when (this) {
            is NetworkError -> {
                this.errorMessage?:"Please check your network connection"
            }
            is ServerError -> {
                this.errorMessage?:"Unexpected Error occurred in server"
            }
            is UnexpectedError -> {
                this.errorMessage?:"Unexpected Error occurred"
            }
        }
        return message
    }
}
