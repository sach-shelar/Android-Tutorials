package com.sach.daggersample.di.module

import com.sach.daggersample.di.Repository
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideRepository(): Repository {
        return Repository()
    }

}