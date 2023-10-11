package com.sach.daggersample.dagger.component

import com.sach.daggersample.ui.MainActivity
import com.sach.daggersample.dagger.module.MessageServiceModule
import com.sach.daggersample.dagger.module.UserRepositoryModule
import com.sach.daggersample.dagger.scope.ActivityScope
import com.sach.daggersample.dagger.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
@Subcomponent(modules = [MessageServiceModule::class, UserRepositoryModule::class])
interface ActivityComponent {

    //this is required for filed injection
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(@BindsInstance retryCount:Int): ActivityComponent
    }

}