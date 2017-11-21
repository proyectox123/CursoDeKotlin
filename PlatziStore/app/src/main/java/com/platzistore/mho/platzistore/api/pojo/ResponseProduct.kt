package com.platzistore.mho.platzistore.api.pojo

import com.google.gson.annotations.SerializedName

data class ResponseProduct(

	@field:SerializedName("payload")
	val payload: List<PayloadItem?>? = null,

	@field:SerializedName("statusCode")
	val statusCode: Int? = null
)