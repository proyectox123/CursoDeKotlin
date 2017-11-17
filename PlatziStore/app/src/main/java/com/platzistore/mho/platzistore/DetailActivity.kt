package com.platzistore.mho.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_description.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent?.extras?.let {
            txtDetailTitle.text = it.getString("title")
            txtDetailDesc.text = it.getString("desc")
            txtDetailPrice.text = "$ ${String.format("%.2f", it.getDouble("price"))}"
        }
    }
}
