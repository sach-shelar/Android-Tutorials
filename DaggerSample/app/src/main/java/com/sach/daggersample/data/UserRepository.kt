package com.sach.daggersample.data

import android.util.Log
import com.sach.daggersample.dagger.AppScope
import javax.inject.Inject
import javax.inject.Singleton


interface UserRepository {
    fun saveUser()
}


@AppScope
class SqlRepository @Inject constructor() : UserRepository {

    override fun saveUser() {
        Log.e(Constant.TAG, "Save Data in SQL")
    }

}

class FirebaseRepository @Inject constructor() : UserRepository {

    override fun saveUser() {
        Log.e(Constant.TAG, "Save Data in Firebase ")
    }

}