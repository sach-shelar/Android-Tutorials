package com.sach.daggersample.dagger.module

import com.sach.daggersample.data.remote.AnalyticsService
import com.sach.daggersample.data.remote.MixPanelAnalyticsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsServiceModule {

    @Singleton
    @Provides
    fun provideAnalyticsService(): AnalyticsService{
        return MixPanelAnalyticsService()
    }
}