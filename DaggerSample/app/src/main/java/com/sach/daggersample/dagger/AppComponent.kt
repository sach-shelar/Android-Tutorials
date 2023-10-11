package com.sach.daggersample.dagger

import com.sach.daggersample.data.UserRegistrationService
import dagger.Component

@Component
interface AppComponent {

    fun userRegistrationService(): UserRegistrationService


}