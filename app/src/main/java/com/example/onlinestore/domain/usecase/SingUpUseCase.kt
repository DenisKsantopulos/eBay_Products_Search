package com.example.onlinestore.domain.usecase

import android.content.Context
import android.content.Intent
import android.widget.EditText
import com.example.onlinestore.domain.models.User
import com.example.onlinestore.domain.repository.UserRepository
import com.example.onlinestore.presentation.account.LogInActivity
import com.example.onlinestore.presentation.account.SingUpActivity

class SingUpUseCase(private val userRepository: UserRepository) {
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
            activity.toast.showToastMessage("Input field cannot be empty", activity)
        } else {
            val user = User(login, email, pass)

            userRepository.addUser(user)
            activity.toast.showToastMessage("User added", activity)

            userLogin.text.clear()
            userEmail.text.clear()
            userPass.text.clear()

            val intent = Intent(context, LogInActivity::class.java)
            context.startActivity(intent)
        }
    }
}