package com.platzistore.mho.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.platzistore.mho.platzistore.api.Endpoints
import com.platzistore.mho.platzistore.api.pojo.PayloadItem
import com.platzistore.mho.platzistore.api.pojo.ResponseProduct
import com.platzistore.mho.platzistore.model.ItemLanding
import com.platzistore.mho.platzistore.model.ItemListPOJO
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //useCoroutines()
        platziStoreLogic()
    }

    private fun platziStoreLogic(){
        recyclerViewLanding.layoutManager = GridLayoutManager(this, 2)

        val retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.15.229:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val endpoint = retrofit.create(Endpoints::class.java)
        val call = endpoint.getList()
        call.enqueue(object : Callback<ResponseProduct> {
            override fun onResponse(call: Call<ResponseProduct>?, response: Response<ResponseProduct>?) {
                if(response?.code() == 200){
                    Log.e("Response", "Message ${response.body().toString()}")
                    fillRecycler(response.body()?.payload)
                }
            }

            override fun onFailure(call: Call<ResponseProduct>?, t: Throwable?) {

            }
        })

//        val itemsShop = (0..20).map {
//            ItemLanding("Title $it", "Description $it", 200.00 + it)
//        }
//
//        val adapter = AdapterLanding(itemsShop)
//        recyclerViewLanding.adapter = adapter
    }

    private fun fillRecycler(payload: List<PayloadItem?>?) {
        val products = payload?.map {
            it?.let { product ->
                with(product){
                    ItemLanding(title ?: "",
                            shortDesc ?: "",
                            price ?: 0.0,
                            imgUrl?: "")
                }
            }
        }?.filter {
            val price = it?.price ?: 0.0
            price > 205
        }

        val adapter = AdapterLanding(products)
        recyclerViewLanding.adapter = adapter
    }

    private fun useCoroutines(){
        recyclerViewLanding.layoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)

        async(UI){
            val data = bg{
                (0..3000).map {
                    ItemListPOJO("Row $it", "", 0.0)
                }
            }
            showData(data.await())
        }
    }

    private fun showData(await: List<ItemListPOJO>) {
        val adapter = AdapterCarShopping(await)
        recyclerViewLanding.adapter = adapter
    }
}