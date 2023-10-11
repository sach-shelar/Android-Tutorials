package com.sach.daggersample.dagger.module

import com.sach.daggersample.dagger.scope.ActivityScope
import com.sach.daggersample.dagger.scope.MessageQualifiers
import com.sach.daggersample.data.remote.EmailService
import com.sach.daggersample.data.remote.NotificationService
import com.sach.daggersample.data.remote.SmsService
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MessageServiceModule() {

    @ActivityScope
    @Named("email")
    @Provides
    fun provideService(retryCount: Int): NotificationService {
        return EmailService(retryCount)
    }

    @ActivityScope
    @MessageQualifiers
    @Provides
    fun provideSmsService(retryCount: Int): NotificationService {
        return SmsService(retryCount)
    }


}