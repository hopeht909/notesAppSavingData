package com.example.notesappsaveonly

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) : SQLiteOpenHelper(context, "notes.db", null, 1) {
    val sqLiteDatabase: SQLiteDatabase=writableDatabase


    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table  deatailsnote ( personnote text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldver: Int, newver: Int) {}

    fun savedata(s1:String): Long {
        val cv= ContentValues()
        cv.put("personnote", s1)
       val status = sqLiteDatabase.insert("deatailsnote",null,cv)
        return status

    }

}