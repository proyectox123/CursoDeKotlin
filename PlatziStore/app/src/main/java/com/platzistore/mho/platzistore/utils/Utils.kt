package com.platzistore.mho.platzistore.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by Mauricio Hernández on 10-Nov-17.
 */

fun Activity.toastLong(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.toastShort(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View{
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}