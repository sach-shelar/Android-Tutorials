package com.sach.daggersample.dagger.component

import com.sach.daggersample.dagger.module.AnalyticsServiceModule
import com.sach.daggersample.data.remote.AnalyticsService
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsServiceModule::class])
interface AppComponent {

    //No need to expose object.
    // fun getAnalyticsService(): AnalyticsService

    fun getActivityComponent(): ActivityComponent.Factory

    fun getActivityComponent2(): SecondActivityComponent

}