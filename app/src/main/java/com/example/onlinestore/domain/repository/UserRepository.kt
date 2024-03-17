package com.example.onlinestore.domain.repository

import android.database.sqlite.SQLiteDatabase
import com.example.onlinestore.domain.models.User

interface UserRepository {

    fun onCreate(db: SQLiteDatabase?)
    fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    fun addUser(user: User)
    fun getUser(login: String, pass: String): Boolean
}