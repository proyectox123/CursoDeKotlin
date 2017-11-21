package com.platzistore.mho.platzistore.api.pojo

import com.google.gson.annotations.SerializedName

data class PayloadItem(

	@field:SerializedName("imgUrl")
	val imgUrl: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("shortDesc")
	val shortDesc: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("longDesc")
	val longDesc: String? = null
)