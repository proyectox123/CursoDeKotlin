package com.example.mho.examplekotlin

import android.widget.EditText

/**
 * Created by Mauricio Hernández on 09-Nov-17.
 */

object Validations {

    @JvmStatic
    fun EditText.validatePassword(): Boolean {
        return this.text.toString().isNotEmpty() &&
                this.text.toString().length.compareTo(6) == 1
    }
}