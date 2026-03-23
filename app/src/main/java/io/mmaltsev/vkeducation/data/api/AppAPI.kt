package io.mmaltsev.vkeducation.data.api

import io.mmaltsev.vkeducation.data.dto.AppInfoDto
import io.mmaltsev.vkeducation.data.dto.AppShortInfoDto
import io.mmaltsev.vkeducation.domain.entities.App
import io.mmaltsev.vkeducation.domain.entities.Category
import kotlinx.coroutines.delay

class AppAPI {
    suspend fun getApps(): List<AppShortInfoDto> {
        delay(1000L)
        return listOf(
            AppShortInfoDto(
                title = "Сбербанк Онлайн - с салютом",
                description = "Больше чем банк",
                category = "Финансы",
                id = 1
            ),
            AppShortInfoDto(
                title = "Яндекс. Браузер - с Алисой",
                description = "Быстрый и безопасный браузер",
                category = "Инструменты",
                id = 2
            ),
            AppShortInfoDto(
                title = "Почта Mail.ru",
                description = "Почтовый клиент для любых ящиков",
                category = "Инструменты",
                id = 3
            ),
            AppShortInfoDto(
                title = "Яндекс навигатор",
                description = "Парковки и заправки - по пути",
                category = "Транспорт",
                id = 4
            ),
            AppShortInfoDto(
                title = "Мой МТС - с салютом",
                description = "Мой МТС - центр экосистемы МТС",
                category = "Инструменты",
                id = 5
            ),
            AppShortInfoDto(
                title = "Яндекс - с Алисой",
                description = "Яндекс - поиск всегда под рукой",
                category = "Инструменты",
                id = 6
            ),
        )
    }

    suspend fun getAppInfo(id: Int): AppInfoDto {
        delay(1000L)
        return AppInfoDto(
            id = id, // temporarily
            name = "Гильдия Героев: Экшен ММО РПГ",
            developer = "VK Play",
            category = Category.GAME,
            ageRating = 12,
            size = 223.7f,
            iconUrl = "https://static.rustore.ru/imgproxy/APsbtHxkVa4MZ0DXjnIkSwFQ_KVIcqHK9o3gHY6pvOQ/preset:web_app_icon_62/plain/https://static.rustore.ru/apk/393868735/content/ICON/3f605e3e-f5b3-434c-af4d-77bc5f38820e.png@webp",
            description = "Легендарный рейд героев в Фэнтези РПГ. Станьте героем гильдии и зразите мастера подземелья!"
        )
    }
}