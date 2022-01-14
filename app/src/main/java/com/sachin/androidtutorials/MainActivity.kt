package com.sachin.androidtutorials

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun displayBaseActivity() {
        (findViewById<Button>(R.id.btnBaseActivityModule)).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}