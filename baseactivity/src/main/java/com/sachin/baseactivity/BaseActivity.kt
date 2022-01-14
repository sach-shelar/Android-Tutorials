package com.sachin.baseactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setContentView())
    }

    abstract fun setContentView(): Int
    abstract fun setTitleToToolbar():Int


}