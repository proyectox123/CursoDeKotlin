package com.platzistore.mho.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.platzistore.mho.platzistore.database.DBOpenHelper
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_description.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.startActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val db = DBOpenHelper.getInstance(this)

        intent?.extras?.let {
            val nameExtra = it.getString("title")
            val descExtra = it.getString("desc")
            val priceExtra = it.getDouble("price")

            txtDetailTitle.text = nameExtra
            txtDetailDesc.text = descExtra
            txtDetailPrice.text = "$ ${String.format("%.2f", priceExtra)}"

            btnDetailBuy.setOnClickListener {
                db?.use {
                    val namePr = "name" to nameExtra
                    val descPr = "Desc" to descExtra
                    val pricePr = "price" to priceExtra

                    insert("Productos", namePr, descPr, pricePr)
                }

                startActivity<ShopCartActivity>()
            }
        }
    }
}