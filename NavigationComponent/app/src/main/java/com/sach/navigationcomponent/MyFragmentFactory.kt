package com.sach.navigationcomponent

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class MyFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            FragmentIntroOne::class.java.name -> FragmentIntroOne()
            FragmentWelcome::class.java.name -> FragmentWelcome()
            else -> {
                return super.instantiate(classLoader, className)
            }
        }


    }
}