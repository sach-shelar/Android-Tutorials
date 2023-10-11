package com.sach.daggersample.data.module

import com.sach.daggersample.data.FirebaseRepository
import com.sach.daggersample.data.SqlRepository
import com.sach.daggersample.data.UserRepository
import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {

    @Provides
    fun provideFirebaseRepository(sqlRepository: SqlRepository): UserRepository {
        return sqlRepository
    }

}