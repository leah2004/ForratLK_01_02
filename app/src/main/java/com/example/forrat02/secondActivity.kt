package com.example.forrat02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val resultImageView = findViewById<ImageView>(R.id.resultImageView)
        val shapeTextView = findViewById<TextView>(R.id.shapeTextView)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        // Получаем данные из Intent
        val shape = intent.getStringExtra("shape")
        val result = intent.getDoubleExtra("result", 0.0)

        // Устанавливаем соответствующее изображение и текст
        if (shape == "Треугольник") {
            resultImageView.setImageResource(R.drawable.triangle)
            shapeTextView.text = "Фигура: Треугольник"
            resultTextView.text = "Периметр: ${"%.2f".format(result)}"
        } else if (shape == "Круг") {
            resultImageView.setImageResource(R.drawable.circle)
            shapeTextView.text = "Фигура: Круг"
            resultTextView.text = "Радиус: ${"%.2f".format(result)}"
        }

        backButton.setOnClickListener {
            val intent = Intent(this, firstActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}