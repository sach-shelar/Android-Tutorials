package com.sach.daggersample.data

import android.util.Log
import javax.inject.Inject
interface NotificationService {
    fun send()
}

class SmsService : NotificationService {
    override fun send() {
        Log.e(Constant.TAG, "SMS Sent")
    }
}
class EmailService : NotificationService {

    override fun send() {
        Log.e(Constant.TAG, "email sent")
    }

}