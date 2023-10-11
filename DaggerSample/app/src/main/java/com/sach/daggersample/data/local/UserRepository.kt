package com.sach.daggersample.data.local

import android.util.Log
import com.sach.daggersample.core.Constant
import com.sach.daggersample.dagger.scope.ActivityScope
import com.sach.daggersample.dagger.scope.AppScope
import com.sach.daggersample.data.remote.AnalyticsService
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository {
    fun saveUser()
}


@ActivityScope
class SqlRepository @Inject constructor(private val analyticsService: AnalyticsService) :
    UserRepository {

    override fun saveUser() {
        analyticsService.addNewEvent("Sql Save", "LOCAL EVENT")
        Log.e(Constant.TAG, "Save Data in SQL")
    }

}

@ActivityScope
class FirebaseRepository @Inject constructor(private val analyticsService: AnalyticsService) :
    UserRepository {

    override fun saveUser() {
        analyticsService.addNewEvent("Firebase Save", "FIREBASE EVENT")
        Log.e(Constant.TAG, "Save Data in Firebase ")
    }

}