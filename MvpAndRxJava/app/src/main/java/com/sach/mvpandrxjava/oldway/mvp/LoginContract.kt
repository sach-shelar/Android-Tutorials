package com.sach.mvpandrxjava.oldway.mvp

import io.reactivex.rxjava3.core.Observable

interface LoginContract {
    interface LoginModel {
        fun login():Observable<Boolean>
    }

    interface LoginPresenter {
        fun login();
        fun attachView(view:LoginView)
    }

    interface LoginView {
        fun showLoader()
        fun showLoginMessage(s: String)
        fun displayUserName()
    }
}