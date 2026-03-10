package org.iframex.templateprojectforvkeducourse

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.iframex.templateprojectforvkeducourse.ui.theme.TemplateProjectForVkEduCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fun updateActivity(inputText: String) {
            if (inputText.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("DATA_TEXT", inputText)
                }
                startActivity(intent)
            }
        }

        enableEdgeToEdge()
        setContent {
            TemplateProjectForVkEduCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val inputText = remember { mutableStateOf("") }
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        TextField(
                            value = inputText.value,
                            onValueChange = { it ->
                                inputText.value = it
                            },
                            modifier = Modifier
                                .width(250.dp)
                                .padding(vertical = 20.dp))
                        Button(onClick = {
                            updateActivity(inputText.value)
                        }, modifier = Modifier
                            .padding(horizontal = 10.dp)) {
                            Text(text="Открыть вторую Activity")
                        }
                    }

                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    TemplateProjectForVkEduCourseTheme {
//        Greeting("Android")
//    }
//}