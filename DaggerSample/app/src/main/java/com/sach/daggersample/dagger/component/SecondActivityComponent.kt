package com.sach.daggersample.dagger.component

import com.sach.daggersample.dagger.module.UserRepositoryModule
import com.sach.daggersample.dagger.scope.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [UserRepositoryModule::class])
interface SecondActivityComponent {


}