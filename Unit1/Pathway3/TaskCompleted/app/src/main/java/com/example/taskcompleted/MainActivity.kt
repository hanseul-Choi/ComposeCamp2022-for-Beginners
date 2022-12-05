package com.example.taskcompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompleted.ui.theme.TaskCompletedTheme

/**
 *  painter는 painterResource로 받음
 *  자식 뷰의 정렬은 Column의 파라미터인 verticalArrangement와 horizontalAlignment를 생각하자
 *  Column의 Modifier는 컨테이너의 크기를 조정하는 느낌
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskCompletedTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    TaskCompletedScreen(
                        taskCompletePainter = painterResource(id = R.drawable.ic_task_completed),
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompletedScreen(
    taskCompletePainter: Painter,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = taskCompletePainter,
            contentDescription = "",
            contentScale = ContentScale.Fit,
        )
        // Bold의 느낌이 있어서 Bold 추가
        Text(
            text = stringResource(R.string.taskCompleteText),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp),
        )
        Text(
            text = stringResource(R.string.taskDescriptionText),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskCompletedTheme {
        TaskCompletedScreen(
            taskCompletePainter = painterResource(id = R.drawable.ic_task_completed),
        )
    }
}