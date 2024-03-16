package com.example.onlinestore.presentation.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.onlinestore.R
import com.example.onlinestore.databinding.ActivityLogInBinding
import com.example.onlinestore.db.DataBase
import com.example.onlinestore.domain.usecase.LogInUseCase
import com.example.onlinestore.domain.utils.CreateToast
import com.example.onlinestore.presentation.MainPageActivity

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding

    private val logInUseCase = LogInUseCase()

    val toast = CreateToast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_log_in)

        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }
        val userLogin: EditText = binding.userLoginLogin
        val userPass: EditText = binding.userPassLogin
        val button: Button = binding.buttonLogin

        button.setOnClickListener {
              logInUseCase.logIn(this, this, userLogin, userPass)
        }
    }
}