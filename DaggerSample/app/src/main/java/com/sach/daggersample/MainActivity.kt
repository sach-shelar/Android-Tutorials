package com.sach.daggersample

import android.content.Intent
import android.os.Bundle
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
import com.sach.daggersample.di.component.DaggerMyActivityComponent
import com.sach.daggersample.di.module.MyActivityModdule
import com.sach.daggersample.di.repository.LoginRepository
import com.sach.daggersample.ui.theme.DaggerSampleTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var loginRepo: LoginRepository

    private val objectList = mutableListOf<LoginRepository>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        repeat(1000) {
            val someObject = LoginRepository()
            objectList.add(someObject)
        }
        setContent {

            val onClick: () -> Unit = {
                startActivity(Intent(this, SecondActivity::class.java))
                finish()
            }


            DaggerSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", onClick)
                }
            }
        }


        //val
        DaggerMyActivityComponent.builder().myActivityModdule(MyActivityModdule()).build()
            .inject(this)
        loginRepo.displayLogFromLoginRepo(this)
    }


}

@Composable
fun Greeting(name: String, context: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Button(onClick = {

            context()
        }) {
            Text(text = "Button Click")
        }

    }
}


