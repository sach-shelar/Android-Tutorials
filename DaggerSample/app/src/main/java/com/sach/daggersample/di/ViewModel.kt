package com.sach.daggersample.di

import javax.inject.Inject

class ViewModel @Inject constructor(
    private val repository: Repository
) {
    init {
        repository.display()
    }
}