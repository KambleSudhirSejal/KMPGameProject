package com.example.kmpgameproject

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.kmpgameproject.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KMPGameProject",
    ) {
        initKoin()
        App()
    }
}