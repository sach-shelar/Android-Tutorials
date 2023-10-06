package com.sach.mvpandrxjava.oldway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sach.mvpandrxjava.databinding.ActivityLoginBinding
import com.sach.mvpandrxjava.oldway.mvp.LoginContract
import com.sach.mvpandrxjava.oldway.mvp.LoginModleImpl
import com.sach.mvpandrxjava.oldway.mvp.LoginPresenterImpl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {
    private val TAG="LoginActivity"
    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    private lateinit var loginPresenter: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            //firstRxJavaSample()
            /*loginPresenter = LoginPresenterImpl(LoginModleImpl())
            loginPresenter.attachView(this)
            loginPresenter.login()*/
            justObservaleExample();

        }
    }

    private fun justObservaleExample() {
       val greeting = "india is my country"
       val observable = Observable.just(greeting)
        observable.subscribeOn(Schedulers.io())

       val observer = object : Observer<String>{
           override fun onSubscribe(d: Disposable) {
               Log.e(TAG, "onSubscribe: ", )

           }

           override fun onError(e: Throwable) {
               Log.e(TAG, "onError: ", )
           }

           override fun onComplete() {
               Log.e(TAG, "onComplete: ", )
           }

           override fun onNext(t: String) {
               Log.e(TAG, "onNext: ", )
               binding.button.setText(t)
           }

       }

        observable.subscribe(observer)

    }

    private fun firstRxJavaSample() {

        val arr: List<Int> = listOf(10, 20, 20, 30)

        var subscribeWith = Observable.just(arr)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : SingleObserver<List<Int>>, Observer<List<Int>> {
                override fun onSubscribe(d: Disposable) {
                    print("onSubscribe")
                }

                override fun onNext(t: List<Int>) {
                    t.forEach {
                        println("Number is - $it")
                    }
                }


                override fun onComplete() {
                    print("OnComplete")
                }

                override fun onError(e: Throwable) {
                    print("onError")
                }

                override fun onSuccess(t: List<Int>) {
                    print("onSuccess")
                }


            })

    }

    override fun showLoader() {
        Toast.makeText(this, "Display Loading", Toast.LENGTH_SHORT).show()
    }

    override fun showLoginMessage(s: String) {
        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
    }

    override fun displayUserName() {
        Toast.makeText(this, "Display Username", Toast.LENGTH_SHORT).show()
    }
}