package com.platzistore.mho.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.platzistore.mho.platzistore.model.ItemLanding
import com.platzistore.mho.platzistore.model.ItemListPOJO
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        useCoroutines()

//        recyclerViewLanding.layoutManager = GridLayoutManager(this, 2)
//
//        val itemsShop = (0..20).map {
//            ItemLanding("Title $it", "Description $it", 200.00 + it)
//        }
//
//        val adapter = AdapterLanding(itemsShop)
//        recyclerViewLanding.adapter = adapter
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