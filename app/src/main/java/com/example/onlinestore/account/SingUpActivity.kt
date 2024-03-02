package com.example.onlinestore.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.onlinestore.MainPageActivity
import com.example.onlinestore.db.DataBase
import com.example.onlinestore.R
import com.example.onlinestore.db.User

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)

        val linkToSingIn: TextView = findViewById(R.id.linkToSingIn)

        linkToSingIn.setOnClickListener{
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
        }

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || email == "" || pass == ""){
                Toast.makeText(this,"Input field cannot be empty",Toast.LENGTH_LONG).show()
            }else{
                val user = User(login, email, pass)

                val db = DataBase(this, null)
                db.addUser(user)
                Toast.makeText(this,"User added",Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()

                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
    }
}