package org.iframex.templateprojectforvkeducourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class SecondActivity: ComponentActivity() {
    lateinit var value: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent.extras
        if (data != null) {
            value = data.getString("DATA_TEXT", "")
        }

        setContent {
            Box(modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Text(text = value, modifier = Modifier
                    .size(64.dp))

            }
        }
    }
}

