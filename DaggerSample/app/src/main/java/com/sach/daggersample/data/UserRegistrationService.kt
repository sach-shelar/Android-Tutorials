package com.sach.daggersample.data

import android.util.Log
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    private val service: NotificationService
) {

    fun registerUser(username:String, password:String) {
        Log.e(Constant.TAG, "New User Registration - $username & $password")
        userRepository.saveUser()
        service.send()
    }

}