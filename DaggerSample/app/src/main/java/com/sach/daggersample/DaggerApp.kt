package com.sach.daggersample

import android.app.Application
import com.sach.daggersample.dagger.AppComponent
import com.sach.daggersample.dagger.DaggerAppComponent
import com.sach.daggersample.data.module.ServiceModule

class DaggerApp: Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(5)
    }

}