package com.sach.daggersample.data.module

import com.sach.daggersample.data.EmailService
import com.sach.daggersample.data.NotificationService
import dagger.Module
import dagger.Provides

@Module
class ServiceModule {

    @Provides
    fun provideService(): NotificationService {
        return EmailService()
    }


}