package com.sach.mvpandrxjava.data

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe


class RxRepository {

    fun simpleObservables(): Observable<String> {

        val stream = Observable.create(ObservableOnSubscribe {
                it.onNext("1")
        })

        return  stream;
    }
}