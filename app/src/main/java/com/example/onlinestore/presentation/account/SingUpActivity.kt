package com.example.onlinestore.presentation.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.onlinestore.presentation.mainpage.MainPageActivity
import com.example.onlinestore.R
import com.example.onlinestore.data.repository.UserRepositoryImpl
import com.example.onlinestore.data.storage.sqlite.DataBaseSqlite
import com.example.onlinestore.domain.usecase.SingUpUseCase
import com.example.onlinestore.domain.utils.CreateToast

class SingUpActivity : AppCompatActivity() {

    val toast = CreateToast()

    private val userRepository by lazy { UserRepositoryImpl(DataBaseSqlite(applicationContext, null)) }
    private val singUp by lazy { SingUpUseCase(userRepository) }
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