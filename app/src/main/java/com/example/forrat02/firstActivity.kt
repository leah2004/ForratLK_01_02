package com.example.forrat02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.content.Intent
import android.view.View
import android.os.Handler
import android.os.Looper

class firstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val shapeSpinner = findViewById<Spinner>(R.id.shapeSpinner)
        val inputEditText = findViewById<EditText>(R.id.inputEditText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val shapeImageView = findViewById<ImageView>(R.id.shapeImageView)

        val shapes = arrayOf("Треугольник", "Круг")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)
        shapeSpinner.adapter = adapter

        var selectedShape = "Треугольник"

        shapeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedShape = shapes[position]
                if (selectedShape == "Треугольник") {
                    shapeImageView.setImageResource(R.drawable.triangle)
                } else {
                    shapeImageView.setImageResource(R.drawable.circle)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
        calculateButton.setOnClickListener {
            val input = inputEditText.text.toString()
            if (input.isEmpty()) {
                Toast.makeText(this, "Введите значения", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val result = if (selectedShape == "Треугольник") {
                    val sides = input.split(" ").map { it.toDouble() }
                    if (sides.size != 2) throw Exception()
                    2 * (sides[0] + sides[1])
                } else {
                    val circumference = input.toDouble()
                    circumference / (2 * Math.PI)
                }

                // Добавляем задержку перед переходом на третий экран
                Handler(Looper.getMainLooper()).postDelayed({
                    val intent = Intent(this, secondActivity::class.java)
                    intent.putExtra("shape", selectedShape)
                    intent.putExtra("result", result)
                    startActivity(intent)
                }, 2000) // Задержка в 2 секунды
            } catch (e: Exception) {
                Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_SHORT).show()
            }
        }

    }
}