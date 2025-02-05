package com.seanaujong.myprofile.internal

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Error(val message: String) : Response<Nothing>()
//    object Loading : Response<Nothing>()
}
