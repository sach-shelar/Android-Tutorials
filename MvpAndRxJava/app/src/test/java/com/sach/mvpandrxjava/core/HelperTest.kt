package com.sach.mvpandrxjava.core

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class HelperTest {

    lateinit var helper: Helper
    @Before
    fun setUp() {
        helper = Helper()
    }

    @Test
    fun  `check number is prime or not`() {
        val result = helper.checkNumberIsPrimeNumberOrNot(123)
    }
}