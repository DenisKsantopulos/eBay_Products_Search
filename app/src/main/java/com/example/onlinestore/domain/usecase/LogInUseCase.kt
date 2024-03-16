package com.example.onlinestore.domain.usecase

import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.onlinestore.databinding.ActivityLogInBinding
import com.example.onlinestore.databinding.ActivityMainPageBinding
import com.example.onlinestore.db.DataBase
import com.example.onlinestore.presentation.MainPageActivity
import com.example.onlinestore.presentation.account.LogInActivity

class LogInUseCase {
    fun logIn(
        activity: LogInActivity,
        context: Context,
        userLogin: EditText,
        userPass: EditText,
    ){
        val login = userLogin.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login == "" || pass == "") {
            //Toast.makeText(this, "Input field cannot be empty", Toast.LENGTH_LONG).show()
            activity.toast.showToastMessage("Input field cannot be empty", activity)
        } else {
            val db = DataBase(activity, null)
            val isLogIn = db.getUser(login, pass)

            if (isLogIn) {
                //Toast.makeText(this, "User $login is authorized", Toast.LENGTH_LONG).show()
                activity.toast.showToastMessage("User $login is authorized", activity)
                userLogin.text.clear()
                userPass.text.clear()

                val intent = Intent(context, MainPageActivity::class.java)
                context.startActivity(intent)
            } else
                //Toast.makeText(this, "User $login is NOT authorized", Toast.LENGTH_LONG).show()
                activity.toast.showToastMessage("User $login is NOT authorized", activity)
        }
    }
}