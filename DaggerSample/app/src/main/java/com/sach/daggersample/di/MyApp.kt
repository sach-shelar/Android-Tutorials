package com.sach.daggersample.di

import android.app.Application
import com.sach.daggersample.di.component.AppComponent
import com.sach.daggersample.di.component.DaggerAppComponent
import com.sach.daggersample.di.module.AppModule
import leakcanary.LeakCanary

class MyApp : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
       appComponent = DaggerAppComponent.builder()
           .appModule(AppModule())
           .build()



    }

}