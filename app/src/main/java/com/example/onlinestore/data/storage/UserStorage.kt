package com.example.onlinestore.data.storage

import android.database.sqlite.SQLiteDatabase
import com.example.onlinestore.data.storage.models.UserData

interface UserStorage {
    fun onCreate(db: SQLiteDatabase?)
    fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    fun add(user: UserData)
    fun get(login: String, pass: String): Boolean
}