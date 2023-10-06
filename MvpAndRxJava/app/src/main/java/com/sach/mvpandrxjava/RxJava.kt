package com.sach.mvpandrxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

data class User(var name: String, val age: Int)
object RxJava {

    private val userList = arrayListOf<User>().apply {
        this.add(User("Sachin", 33))
        this.add(User("Nilesh", 32))
        this.add(User("Vishal", 31))
        this.add(User("Pradip", 33))
    }

    fun getSizeOfUserList(): Int {
        return userList.size
    }

    fun getJustObservables(): Observable<String> {
        return Observable.just("sachin shelar");
    }

    fun getMapObservables(): Observable<User> {
        return Observable.create(ObservableOnSubscribe {
            userList.forEach { user ->
                it.onNext(user)
            }

            it.onComplete()
        })
    }

}

fun main() {

    val observable = RxJava.getMapObservables();
    val compositeDisposable = CompositeDisposable()
    compositeDisposable.add(
        observable
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .map(object: Function<User>, io.reactivex.rxjava3.functions.Function<User, User> {
                override fun apply(t: User): User {
                    t.name="${t.name} - The Android Developer"
                    return t
                }
            })
            .subscribeWith(object: DisposableObserver<User>(){
                override fun onNext(t: User) {
                    println(t.name)
                }

                override fun onError(e: Throwable) {
                    println(e.message)
                }

                override fun onComplete() {
                    println("On Complete Called")
                }
            })

    )

}