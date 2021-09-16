package com.example.coinapp.common


enum class AppErrorType{

    ServerError,
    NetworkError,
    UnexpectedError;

    fun errorMessage( ): String {
        return when(this) {
            ServerError -> "Unexpected Error occurred in server"
            NetworkError -> "Please check your network connection"
            UnexpectedError -> "Unexpected error occurred"
        }
    }
}
