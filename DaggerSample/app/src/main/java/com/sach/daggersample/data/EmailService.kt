package com.sach.daggersample.data

import android.util.Log
import javax.inject.Inject
interface NotificationService {
    fun send()
}

class SmsService(private val retryCount: Int) : NotificationService {
    override fun send() {
        Log.e(Constant.TAG, "SMS Sent - retry count $retryCount")
    }
}
class EmailService(private val retryCount:Int) : NotificationService {

    override fun send() {

        Log.e(Constant.TAG, "email sent - retry count $retryCount")
    }

}