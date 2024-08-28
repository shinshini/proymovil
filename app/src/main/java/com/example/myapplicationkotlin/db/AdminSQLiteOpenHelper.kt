package com.example.myapplicationkotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AdminSQLiteOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE productos (" +
                    "id_productos INTEGER PRIMARY KEY, " +
                    "nombre TEXT, " +
                    "precio REAL)"
        )

        /*val createTableQuery = "CREATE TABLE productos (" +
                "id_producto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "precio REAL NOT NULL)"
        db?.execSQL(createTableQuery)*/
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Aquí podrías manejar las actualizaciones de la base de datos.
        db?.execSQL("DROP TABLE IF EXISTS productos")
        onCreate(db)
    }
}