package com.sach.daggersample.di.repository

import android.app.Activity
import com.sach.daggersample.MainActivity

class LoginRepository {

    lateinit var activity: Activity
    fun displayLogFromLoginRepo(mainActivity: MainActivity) {
        this.activity = mainActivity
        println("This is from login repository")
    }


}