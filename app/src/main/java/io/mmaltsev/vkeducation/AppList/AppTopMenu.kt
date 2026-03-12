package io.mmaltsev.vkeducation.AppList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import io.mmaltsev.vkeducation.R

@Composable
fun AppTopMenu(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        Column(modifier = Modifier) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.background(Color.Blue).padding(20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.rustore),
                        contentDescription = null,
                        modifier = Modifier
                            .width(64.dp)
                            .height(64.dp)
                    )
                    Text(
                        text = "RuStore",
                        fontSize = 32.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.outline_apps_24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .width(64.dp)
                        .height(64.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Cyan)
                        .padding(10.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun AppTopMenuPreview() {
    AppTopMenu(modifier = Modifier
        .fillMaxWidth()
        .safeDrawingPadding())
}