package com.example.mho.examplekotlin

import android.content.SharedPreferences

/**
 * Created by Mauricio Hernández on 09-Nov-17.
 */
fun SharedPreferences.edit(func:SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.func()
    editor.apply()
}