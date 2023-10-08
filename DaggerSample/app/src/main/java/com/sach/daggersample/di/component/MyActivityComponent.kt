package com.sach.daggersample.di.component

import com.sach.daggersample.MainActivity
import com.sach.daggersample.di.module.MyActivityModdule
import dagger.Component


@Component(modules = [MyActivityModdule::class])
interface MyActivityComponent {
    fun inject(mainActivity: MainActivity)
}