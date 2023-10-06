package com.sach.mvpandrxjava.oldway.mvp

import io.reactivex.rxjava3.core.Observable

class LoginModleImpl : LoginContract.LoginModel {
    val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    override fun login(): Observable<Boolean> {
        return loginRepository.doLogin("india")
    }
}