package com.sach.daggersample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sach.daggersample.dagger.DaggerAppComponent
import com.sach.daggersample.data.Constant
import com.sach.daggersample.data.NotificationService
import com.sach.daggersample.data.UserRegistrationService
import com.sach.daggersample.data.module.ServiceModule
import com.sach.daggersample.ui.theme.DaggerSampleTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var userRegistrationService2: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val component = (application as DaggerApp).appComponent
            Log.e(Constant.TAG,"${component.toString()}")
            component.inject(this)


            userRegistrationService2.registerUser("india@gmail.com", "india@123")
            userRegistrationService.registerUser("india@gmail.com", "india@123")









            DaggerSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }


}



