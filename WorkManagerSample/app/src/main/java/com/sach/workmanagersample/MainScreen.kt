package com.sach.workmanagersample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen(startWorkManager: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        MyVerticalSpacer()
        TopBarView()
        MyVerticalSpacer()
        WorkerThreadStatus(startWorkManager)

    }
}

@Composable
fun MyVerticalSpacer(size: Dp = 12.dp) {
    Spacer(modifier = Modifier.padding(top = size))
}

@Composable
fun TopBarView() {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.str_welcome_dear),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = stringResource(R.string.str_slogun),
            fontSize = 12.sp,
            fontWeight = FontWeight.Light
        )
        Image(
            painter = painterResource(id = R.drawable.work_time),
            contentDescription = null,
            Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(top = 12.dp)
        )

    }


}


@Composable
fun WorkerThreadStatus(startWorkManager: () -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .border(
                    1.dp,
                    Color.Green,
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(8.dp)

        ) {
            Row(
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Worker Thread", fontSize = 16.sp)
                Spacer(modifier = Modifier.padding(start = 16.dp))
                Text(text = "Status: - ", fontSize = 24.sp)
            }
        }

        Button(
            onClick = {
                startWorkManager()
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text(text = "Start Worker Thread")
        }
    }
}

