package com.platzistore.mho.platzistore.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by mauricio.hernandez on 17/11/2017.
 */
class DBOpenHelper(context: Context) : ManagedSQLiteOpenHelper(context, "platzistore", null, 1){

    companion object {
        private var instance: DBOpenHelper? = null

        fun getInstance(context: Context) : DBOpenHelper? = if(instance == null){
                instance = DBOpenHelper(context)
                instance
            }else{
                instance
            }
    }

    val Context.database: DBOpenHelper?
        get() = getInstance(applicationContext)

    override fun onCreate(db: SQLiteDatabase?) {
        val id = "id" to INTEGER + PRIMARY_KEY
        val name = "name" to TEXT
        val desc = "desc" to TEXT
        val price = "price" to TEXT

        db?.createTable("Productos", true, id, name, desc, price)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable("Productos", true)
    }

}