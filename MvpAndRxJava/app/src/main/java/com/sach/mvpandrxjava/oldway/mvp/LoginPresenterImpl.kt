package com.sach.mvpandrxjava.oldway.mvp

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginPresenterImpl(val model: LoginContract.LoginModel) : LoginContract.LoginPresenter {
    lateinit var loginView: LoginContract.LoginView


    override fun login() {
        loginView.showLoader()

        val loginObservable = model.login()

          val disposable =  loginObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : Observer<Boolean>{
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun onComplete() {
                        Thread.sleep(5000)
                        loginView.displayUserName()
                    }

                    override fun onNext(it: Boolean) {
                        if (it) {
                            loginView.showLoginMessage("Login Successfully")
                        } else {
                            loginView.showLoginMessage("Login Failed")
                        }
                    }

                })


    }

    override fun attachView(view: LoginContract.LoginView) {
        loginView = view
    }

}