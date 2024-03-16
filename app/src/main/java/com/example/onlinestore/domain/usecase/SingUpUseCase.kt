package com.example.onlinestore.domain.usecase

import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.example.onlinestore.db.DataBase
import com.example.onlinestore.db.User
import com.example.onlinestore.presentation.account.LogInActivity
import com.example.onlinestore.presentation.account.SingUpActivity

class SingUpUseCase {
    fun singUp(
        activity: SingUpActivity,
        context: Context,
        userLogin: EditText,
        userEmail: EditText,
        userPass: EditText
    ){
        val login = userLogin.text.toString().trim()
        val email = userEmail.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login == "" || email == "" || pass == "") {
            //Toast.makeText(this, "Input field cannot be empty", Toast.LENGTH_LONG).show()
            activity.toast.showToastMessage("Input field cannot be empty", activity)
        } else {
            val user = User(login, email, pass)

            val db = DataBase(activity, null)
            db.addUser(user)
            //Toast.makeText(this, "User added", Toast.LENGTH_LONG).show()
            activity.toast.showToastMessage("User added", activity)

            userLogin.text.clear()
            userEmail.text.clear()
            userPass.text.clear()

            val intent = Intent(context, LogInActivity::class.java)
            context.startActivity(intent)
        }
    }
}