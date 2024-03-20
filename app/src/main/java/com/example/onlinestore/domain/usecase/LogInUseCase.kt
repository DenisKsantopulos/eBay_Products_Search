package com.example.onlinestore.domain.usecase

import android.content.Context
import android.content.Intent
import android.widget.EditText
import com.example.onlinestore.domain.repository.UserRepository
import com.example.onlinestore.presentation.mainpage.MainPageActivity
import com.example.onlinestore.presentation.account.LogInActivity

class LogInUseCase(private val userRepository: UserRepository) {
    fun logIn(
        activity: LogInActivity,
        context: Context,
        userLogin: EditText,
        userPass: EditText,
    ){
        val login = userLogin.text.toString().trim()
        val pass = userPass.text.toString().trim()

        if (login == "" || pass == "") {
            activity.toast.showToastMessage("Input field cannot be empty", activity)
        } else {
            val isLogIn = userRepository.getUser(login, pass)

            if (isLogIn) {
                activity.toast.showToastMessage("User $login is authorized", activity)
                userLogin.text.clear()
                userPass.text.clear()

                val intent = Intent(context, MainPageActivity::class.java)
                context.startActivity(intent)
            } else
                activity.toast.showToastMessage("User $login is NOT authorized", activity)
        }
    }
}