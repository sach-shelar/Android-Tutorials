package com.sach.daggersample.dagger

import com.sach.daggersample.MainActivity
import com.sach.daggersample.data.NotificationService
import com.sach.daggersample.data.UserRegistrationService
import com.sach.daggersample.data.module.ServiceModule
import com.sach.daggersample.data.module.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ServiceModule::class, UserRepositoryModule::class])
interface AppComponent {

    //this is required for filed injection
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int): AppComponent
    }

}