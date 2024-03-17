package com.example.onlinestore.data.repository

import android.database.sqlite.SQLiteDatabase
import com.example.onlinestore.data.storage.UserStorage
import com.example.onlinestore.data.storage.models.UserData
import com.example.onlinestore.domain.models.User
import com.example.onlinestore.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage): UserRepository{
    override fun onCreate(db: SQLiteDatabase?) {
        userStorage.onCreate(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        userStorage.onUpgrade(db,oldVersion,newVersion)
    }

    override fun addUser(user: User) {
        val userData = UserData(user.login, user.email, user.pass)

        userStorage.add(userData)
    }

    override fun getUser(login: String, pass: String): Boolean {
        return userStorage.get(login, pass)
    }
}