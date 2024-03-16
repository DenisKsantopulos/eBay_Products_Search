package com.example.onlinestore.presentation.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.onlinestore.presentation.MainPageActivity
import com.example.onlinestore.db.DataBase
import com.example.onlinestore.R
import com.example.onlinestore.db.User
import com.example.onlinestore.domain.usecase.SingUpUseCase
import com.example.onlinestore.domain.utils.CreateToast

class SingUpActivity : AppCompatActivity() {

    val toast = CreateToast()

    private val singUp = SingUpUseCase()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        val linkToSingIn: TextView = findViewById(R.id.linkToSingIn)

        linkToSingIn.setOnClickListener {
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
        }

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            singUp.singUp(this, this, userLogin, userEmail, userPass)
        }
    }
}