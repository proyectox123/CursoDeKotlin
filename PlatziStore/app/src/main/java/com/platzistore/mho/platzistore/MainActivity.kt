package com.platzistore.mho.platzistore

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        label_hello_world.text = "Hello Android Extensions!"

        //toastShort("short Toast!")

        toast("short Toast!")

        label_hello_world.setOnClickListener {
            startActivity<DetailActivity>("any_text" to "Hello from Anko!")
        }
    }
}
