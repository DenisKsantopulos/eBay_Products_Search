package com.example.onlinestore.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.onlinestore.db.DataBase
import com.example.onlinestore.MainPageActivity
import com.example.onlinestore.R

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener{
            val intent = Intent(this, SingUpActivity::class.java)
            startActivity(intent)
        }

        val userLogin: EditText = findViewById(R.id.user_login_login)
        val userPass: EditText = findViewById(R.id.user_pass_login)
        val button: Button = findViewById(R.id.button_login)

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == ""){
                Toast.makeText(this,"Input field cannot be empty", Toast.LENGTH_LONG).show()
            }else{
                val db = DataBase(this, null)
                val isLogIn = db.getUser(login, pass)

                if (isLogIn) {
                    Toast.makeText(this, "User $login is authorized", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, MainPageActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "User $login is NOT authorized", Toast.LENGTH_LONG).show()
            }
        }
    }
}