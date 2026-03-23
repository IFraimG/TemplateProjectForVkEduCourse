package io.mmaltsev.vkeducation.data.api

import io.mmaltsev.vkeducation.data.dto.ScreenshotDto
import kotlinx.coroutines.delay

class ScreenshotAPI {

    suspend fun getScreenshotsByAppID(): List<ScreenshotDto> {
        delay(1000L)
        return listOf(
            ScreenshotDto(
                id = 1,
                appId = 7,
                url = "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp"
            ),
            ScreenshotDto(
                id = 2,
                appId = 7,
                url = "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            ),
            ScreenshotDto(
                id = 3,
                appId = 7,
                url = "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            ),
            ScreenshotDto(
                id = 4,
                appId = 7,
                url = "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp"
            )
        )
    }
}