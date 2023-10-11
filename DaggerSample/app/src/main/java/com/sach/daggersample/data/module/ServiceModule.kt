package com.sach.daggersample.data.module

import com.sach.daggersample.data.EmailService
import com.sach.daggersample.data.NotificationService
import com.sach.daggersample.data.SmsService
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ServiceModule {

    @Named("email")
    @Provides
    fun provideService(): NotificationService {
        return EmailService()
    }

    @Named("sms")
    @Provides
    fun provideSmsService(): NotificationService{
        return SmsService()
    }


}