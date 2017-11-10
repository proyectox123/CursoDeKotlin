package com.example.mho.examplekotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * Created by Mauricio Hernández on 09-Nov-17.
 */

class MainActivity : AppCompatActivity() {

    lateinit var user: EditText
    lateinit var password: EditText
    lateinit var login: Button //lateinit Aún sin inicializar
    private val TAG = MainActivity::class.java.simpleName
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = findViewById(R.id.loginUser)
        password = findViewById(R.id.loginPass)
        login = findViewById(R.id.loginSend)

        login.setOnClickListener {
            logIn()
        }

        sharedPreferences = getSharedPreferences("exampleKotlin", Context.MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("LogIn", false)
        if(isLogged){
            startActivity(Intent(this@MainActivity, ListActivity::class.java))
            finish()
        }
    }

    private fun logIn(){
        val isValid = password.validatePassword()
        Log.d(TAG, "OnClick: " + isValid)
        if (isValid) {
            sharedPreferences.edit() {
                putBoolean("LogIn", true)
            }

            val intent = Intent(this@MainActivity, ListActivity::class.java)
            intent.putExtra("UserKotlin", user.text.toString())
            startActivity(intent)
            finish()
            return
        }

        Toast.makeText(this@MainActivity,
                "Incorrect password!",
                Toast.LENGTH_LONG).show()
    }
}
