package com.sach.daggersample.data

import android.util.Log
import javax.inject.Inject


interface UserRepository {
    fun saveUser()
}


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