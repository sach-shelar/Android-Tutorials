package com.sach.daggersample.di.component

import com.sach.daggersample.di.ViewModel
import com.sach.daggersample.di.module.AppModule
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(viewModel: ViewModel)
}