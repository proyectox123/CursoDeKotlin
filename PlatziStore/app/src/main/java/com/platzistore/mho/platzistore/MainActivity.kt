package com.platzistore.mho.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import com.platzistore.mho.platzistore.model.ItemLanding
import com.platzistore.mho.platzistore.model.ItemListPOJO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewLanding.layoutManager = GridLayoutManager(this, 2)

        val itemsShop = (0..20).map {
            ItemLanding("Title $it", "Description $it", 200.00 + it)
        }

        val adapter = AdapterLanding(itemsShop)
        recyclerViewLanding.adapter = adapter
    }
}
