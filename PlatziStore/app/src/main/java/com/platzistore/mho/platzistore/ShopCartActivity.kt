package com.platzistore.mho.platzistore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.platzistore.mho.platzistore.database.DBOpenHelper
import com.platzistore.mho.platzistore.model.ItemListPOJO
import kotlinx.android.synthetic.main.activity_shop_cart.*
import org.jetbrains.anko.db.select

class ShopCartActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterCarShopping

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_cart)

        recyclerViewShopCart.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
//        val itemsShop = (0..20).map {
//            ItemListPOJO("Title $it", "Description $it", 200.00 + it)
//        }

        adapter = AdapterCarShopping(ArrayList<ItemListPOJO>())
        recyclerViewShopCart.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        val db = DBOpenHelper.getInstance(this)
        db?.use {
            select("Productos").exec {
                val itemsShop = ArrayList<ItemListPOJO>()
                this.moveToFirst()
                do{
                    val title = this.getString(1) ?: ""
                    val desc = this.getString(2) ?: ""
                    val price = this.getDouble(3)

                    itemsShop.add(ItemListPOJO(title, desc, price))
                }while (this.moveToNext())

                adapter.addItems(itemsShop)

                /*
                Log.e("Columnas", "${this.columnCount}")
                Log.e("Columnas", "${this.columnNames.size}")

                (this.columnNames).map {
                    Log.e("Columna: ", "$it")
                    Log.e("Columna: ", "${this.getColumnIndex(it)}")
                    Log.e("Columna: ", "${this.getColumnName(this.getColumnIndex(it))}")
                }

                val itemsShop = (this.columnNames).map {
                    ItemListPOJO("Title $it", "Description $it", 200.00 + it)
                }

                do{
                    Log.e("Value", "${this.getString(1) ?: ""}")
                    Log.e("Value", "${this.getString(2) ?: ""}")
                    Log.e("Value", "${this.getDouble(3)}")
                    //

                }while (this.moveToNext())
                */
            }
        }
    }
}
