package com.sach.daggersample.dagger.module

import com.sach.daggersample.dagger.scope.ActivityScope
import com.sach.daggersample.dagger.scope.AppScope
import com.sach.daggersample.data.local.SqlRepository
import com.sach.daggersample.data.local.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UserRepositoryModule {

    @ActivityScope
    @Provides
    fun provideFirebaseRepository(sqlRepository: SqlRepository): UserRepository {
        return sqlRepository
    }

}