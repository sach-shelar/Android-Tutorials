package com.sach.mvpandrxjava.oldway.mvp

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe

class LoginRepository {
    fun doLogin(
        username: String
    ): Observable<Boolean> {

        return Observable.create {
            Thread.sleep(4000)

            if (username == "sachin") {
                it.onNext(true)
            } else {
                it.onNext(false)
            }
            Thread.sleep(5000)
            it.onComplete()

        }
    }
}