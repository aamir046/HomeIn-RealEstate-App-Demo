package com.example.mvvmclean.domain.responses

import com.google.gson.annotations.SerializedName

abstract class BaseResponse(
    @SerializedName("status_code") open val status_code: Int,
    @SerializedName("status") open val status: String,
    @SerializedName("message") open val message: String
)