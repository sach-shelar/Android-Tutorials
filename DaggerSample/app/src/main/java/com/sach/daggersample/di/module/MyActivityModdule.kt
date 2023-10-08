package com.sach.daggersample.di.module

import com.sach.daggersample.di.component.MyActivityComponent
import com.sach.daggersample.di.repository.LoginRepository
import dagger.Module
import dagger.Provides

@Module
class MyActivityModdule {

    @Provides
    fun providerLoginRepository(): LoginRepository {
        return LoginRepository()
    }
}