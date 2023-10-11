package com.sach.daggersample.data.module

import com.sach.daggersample.dagger.MessageQualifiers
import com.sach.daggersample.data.EmailService
import com.sach.daggersample.data.NotificationService
import com.sach.daggersample.data.SmsService
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ServiceModule() {

    @Named("email")
    @Provides
    fun provideService(retryCount: Int): NotificationService {
        return EmailService(retryCount)
    }

    @MessageQualifiers
    @Provides
    fun provideSmsService(retryCount: Int): NotificationService{
        return SmsService(retryCount)
    }


}