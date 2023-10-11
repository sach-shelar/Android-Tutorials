package com.sach.daggersample.data

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun saveUser() {
        Log.e(Constant.TAG, "user details saved in DB ")
    }

}