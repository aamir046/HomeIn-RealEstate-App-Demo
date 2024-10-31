package com.example.mvvmclean.domain.status

sealed class Status<out T : Any>{
    data class Success<out T : Any>(val data: T?) : Status<T>()
    data class Error(val message: String?, val statusCode: Int? = null) : Status<Nothing>()
    data class Loading(val message: String="") : Status<Nothing>()
}