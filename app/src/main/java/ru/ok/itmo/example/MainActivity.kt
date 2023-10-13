package ru.ok.itmo.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val buttonStart = findViewById<Button>(R.id.button_start)

        buttonStart.setOnClickListener {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
    }
}