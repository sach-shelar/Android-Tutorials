package com.sach.mvpandrxjava.core

class Helper {


    //Check number is prime or not
    fun checkNumberIsPrimeNumberOrNot(n:Int): Boolean {

        for (i in 2..n) {

            if(n%i == 0){
                return false
            }

        }
        return true;
    }
}