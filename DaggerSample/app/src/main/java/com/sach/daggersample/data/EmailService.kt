package com.sach.daggersample.data

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor() {

    fun email() {
        Log.e(Constant.TAG, "email sent")
    }

}