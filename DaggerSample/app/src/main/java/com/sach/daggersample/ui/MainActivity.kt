package com.sach.daggersample.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sach.daggersample.DaggerApp
import com.sach.daggersample.core.Constant
import com.sach.daggersample.dagger.component.DaggerActivityComponent
import com.sach.daggersample.data.repository.UserRegistrationService
import com.sach.daggersample.ui.theme.DaggerSampleTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            /*val component =
            Log.e(Constant.TAG,"${component.toString()}")
            component.inject(this)
*/
            val appComponent = (application as DaggerApp).appComponent
            val component = DaggerActivityComponent.factory().create(10,appComponent)
            component.inject(this)
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



