package com.sach.workmanagersample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.sach.workmanagersample.ui.theme.WorkManagerSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            WorkManagerSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(::startWorkManager)
                }
            }
        }
    }

    private fun startWorkManager() {
        //Prepare Data, that need to pass
        val data = Data.Builder().apply {
            putInt("num1", 5)
            putInt("num2", 13)
        }.build()
        //Create OneTimeWork Request
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorkManager::class.java).apply {
            setInputData(data)
        }.build()

        //Assign request to work manager.
        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)

        //Observe the work result.
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.id)
            .observe(this, Observer {
                when (it.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        val result = it.outputData.getInt("res", 0)
                        Toast.makeText(this, "Result is - $result", Toast.LENGTH_SHORT).show()
                    }

                    WorkInfo.State.FAILED -> {
                        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        Toast.makeText(this, "Running", Toast.LENGTH_SHORT).show()
                    }
                }
            })


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WorkManagerSampleTheme {

    }
}