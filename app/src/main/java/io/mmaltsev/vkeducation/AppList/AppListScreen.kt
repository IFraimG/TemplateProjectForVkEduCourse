package io.mmaltsev.vkeducation.AppList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.ui.theme.RuStoreBlue


@Composable
fun AppListScreen(navController: NavController?) {
    val listCompanies = remember { mutableListOf(
        CompanyInfo(title = "Сбербанк Онлайн - с салютом", description = "Больше чем банк", category = "Финансы", drawableLogoId = R.drawable.sber),
        CompanyInfo(title = "Яндекс. Браузер - с Алисой", description = "Быстрый и безопасный браузер", category = "Инструменты", drawableLogoId = R.drawable.yandexbrowser),
        CompanyInfo(title = "Почта Mail.ru", description = "Почтовый клиент для любых ящиков", category = "Инструменты", drawableLogoId = R.drawable.mailrulogo),
        CompanyInfo(title = "Яндекс навигатор", description = "Парковки и заправки - по пути", category = "Транспорт", drawableLogoId = R.drawable.navigator),
        CompanyInfo(title = "Мой МТС - с салютом", description = "Мой МТС - центр экосистемы МТС", category = "Инструменты", drawableLogoId = R.drawable.mtc),
        CompanyInfo(title = "Яндекс - с Алисой", description = "Яндекс - поиск всегда под рукой", category = "Инструменты", drawableLogoId = R.drawable.alisa),
    ) }
    
    fun navigateToOtherScreen() = navController?.navigate(Screen.Detail.route)

    Column(modifier = Modifier
            .fillMaxSize()
            .background(RuStoreBlue)) {
        AppTopMenu(Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
        )
        Card(colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )) {
            LazyColumn(contentPadding = PaddingValues(vertical = 20.dp)) {
                listCompanies.forEach { it ->
                    item {
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxSize()
                                .clickable {
                                    navigateToOtherScreen()
                                }
                                .padding(horizontal = 20.dp)) {
                            Image(
                                painter = painterResource(it.drawableLogoId),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(86.dp)
                                    .height(86.dp)
                                    .padding(15.dp)
                                    .clip(RoundedCornerShape(10.dp))

                            )
                            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
                                Text(text = it.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold)
                                Text(text = it.description,
                                    fontSize = 12.sp)
                                Text(text = it.category,
                                    fontSize = 12.sp,
                                    color = Color.Gray)
                            }
                        }
                        HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp),
                            thickness = DividerDefaults.Thickness,
                            color = Color.LightGray)
                    }
                }

            }
        }
    }
}

@Preview
@Composable
private fun AppListScreenPreview() {
    AppListScreen(null)
}