package com.sachin.baseactivity

import android.os.Bundle
import android.util.Log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MainActivity", "onCreate: ")
    }

    override fun setContentView(): Int = R.layout.activity_main

    override fun setTitleToToolbar(): Int = R.string.app_name
}