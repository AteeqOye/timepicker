package com.example.timepicker

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        button = findViewById(R.id.button)
        text = findViewById(R.id.timePickerTv)

        button.setOnClickListener {
            val hours = Calendar.HOUR
            val minutes = Calendar.MINUTE
            val timePicker = TimePickerDialog(this, { _, hour, minute ->

                val format = String.format("%02d:%02d", hour, minute)

                text.text = format
            }, hours, minutes, true)
            timePicker.show()
        }

    }
}