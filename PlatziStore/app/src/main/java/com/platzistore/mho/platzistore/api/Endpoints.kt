package com.platzistore.mho.platzistore.api

import com.platzistore.mho.platzistore.api.pojo.ResponseProduct
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by mauricio.hernandez on 20/11/2017.
 */
interface Endpoints {

    @GET("list")
    fun getList() : Call<ResponseProduct>
}