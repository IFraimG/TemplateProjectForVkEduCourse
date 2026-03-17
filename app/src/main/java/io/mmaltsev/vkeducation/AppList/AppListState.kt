package io.mmaltsev.vkeducation.AppList

import io.mmaltsev.vkeducation.R
import kotlinx.coroutines.flow.MutableStateFlow

data class AppListState(
    val listCompanies: List<CompanyInfo> = listOf(
        CompanyInfo(title = "Сбербанк Онлайн - с салютом", description = "Больше чем банк", category = "Финансы", drawableLogoId = R.drawable.sber),
        CompanyInfo(title = "Яндекс. Браузер - с Алисой", description = "Быстрый и безопасный браузер", category = "Инструменты", drawableLogoId = R.drawable.yandexbrowser),
        CompanyInfo(title = "Почта Mail.ru", description = "Почтовый клиент для любых ящиков", category = "Инструменты", drawableLogoId = R.drawable.mailrulogo),
        CompanyInfo(title = "Яндекс навигатор", description = "Парковки и заправки - по пути", category = "Транспорт", drawableLogoId = R.drawable.navigator),
        CompanyInfo(title = "Мой МТС - с салютом", description = "Мой МТС - центр экосистемы МТС", category = "Инструменты", drawableLogoId = R.drawable.mtc),
        CompanyInfo(title = "Яндекс - с Алисой", description = "Яндекс - поиск всегда под рукой", category = "Инструменты", drawableLogoId = R.drawable.alisa),
    )
)