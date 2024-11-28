package com.example.forrat02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import android.os.Handler
import android.os.Looper

class regis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)

        val loginEditText = findViewById<EditText>(R.id.loginEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (login == "ects" && password == "ects2024") {

                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, firstActivity::class.java)
                    startActivity(intent)
                }, 2000) // Задержка в 2 секунды
            } else {
                Toast.makeText(this, "Данные неверны", Toast.LENGTH_SHORT).show()
            }
        }
    }
}