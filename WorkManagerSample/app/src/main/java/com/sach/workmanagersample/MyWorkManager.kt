package com.sach.workmanagersample

import android.content.Context
import android.os.Looper
import android.util.Log
import androidx.work.Data
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.logging.Handler

class MyWorkManager(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    private val TAG: String? = MyWorkManager::class.java.simpleName

    override fun doWork(): Result {
        Thread.sleep(5000)
        Log.e(TAG, "doWork: Started")
        var num1 = inputData.getInt("num1", 10)
        val num2 = inputData.getInt("num2", 10)

        val addition = num1 + num2
        Log.e(TAG, "doWork: LoginResult - $addition")

        return if (addition in 11..19) {
            val outputData = Data.Builder().apply {
                putInt("res", addition)
            }.build()
            Log.e(TAG, "doWork: Success")
            Result.success(outputData)
        } else if (addition < 10) {
            Log.e(TAG, "doWork: Retry")
            Result.retry()
        } else {
            Log.e(TAG, "doWork: Failure")
            Result.failure()
        }




    }

}