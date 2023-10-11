package com.sach.daggersample.data.repository

import android.util.Log
import com.sach.daggersample.core.Constant
import com.sach.daggersample.dagger.scope.MessageQualifiers
import com.sach.daggersample.data.local.UserRepository
import com.sach.daggersample.data.remote.NotificationService
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifiers private val service: NotificationService
) {

    fun registerUser(username: String, password: String) {
        Log.e(Constant.TAG, "New User Registration - $username & $password")
        userRepository.saveUser()
        service.send()
    }

}