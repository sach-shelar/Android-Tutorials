package com.sach.daggersample

import android.app.Application
import com.sach.daggersample.dagger.component.ActivityComponent
import com.sach.daggersample.dagger.component.AppComponent
import com.sach.daggersample.dagger.component.DaggerAppComponent

class DaggerApp : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
    }

}