package io.mmaltsev.vkeducation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.mmaltsev.vkeducation.AppList.NavigationStack
import io.mmaltsev.vkeducation.ui.theme.VkEducationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VkEducationTheme {
                NavigationStack()
//                    AppDetailsScreen(
//                        Modifier
//                            .fillMaxSize()
//                            .safeDrawingPadding()
//                    )
            }
        }
    }
}