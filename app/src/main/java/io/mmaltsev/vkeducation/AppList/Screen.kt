package io.mmaltsev.vkeducation.AppList

sealed class Screen(val route: String) {
    object Main: Screen("main_screen")
    object Detail: Screen("detail_screen")
}