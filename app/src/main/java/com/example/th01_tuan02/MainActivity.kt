package com.example.th01_tuan02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val textResult = findViewById<TextView>(R.id.textResult)

        btnCheck.setOnClickListener {
            val age: Int? = edtAge.text.toString().toIntOrNull()
            val name: String = edtName.text.toString()
            if (age == null || age <= 0) {
                Toast.makeText(this, "Vui lòng nhập tuổi hợp lệ!", Toast.LENGTH_SHORT).show()
            } else {
                textResult.text = when {
                    age > 65 -> "${name} bạn là người già"
                    age in 6..65 -> "${name} bạn là người trẻ"
                    age in 2..6 -> "${name} bạn là nrẻ nhỏ"
                    else -> "${name} bạn là em bé"
                }
            }
        }

    }
}