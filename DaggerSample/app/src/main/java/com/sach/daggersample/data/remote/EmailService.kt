package com.sach.daggersample.data.remote

import android.util.Log
import com.sach.daggersample.core.Constant
import com.sach.daggersample.dagger.scope.ActivityScope

interface NotificationService {
    fun send()
}

@ActivityScope
class SmsService(private val retryCount: Int) : NotificationService {
    override fun send() {
        Log.e(Constant.TAG, "SMS Sent - retry count $retryCount")
    }
}
@ActivityScope
class EmailService(private val retryCount:Int) : NotificationService {

    override fun send() {

        Log.e(Constant.TAG, "email sent - retry count $retryCount")
    }

}