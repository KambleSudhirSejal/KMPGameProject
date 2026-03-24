package com.example.kmpgameproject.di

import com.example.coreNetwork.di.getCoreNetworkModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication : ((KoinApplication) -> Unit)?= null) {

    startKoin {
        koinApplication?.invoke(this)
        modules(
            getCoreNetworkModule()
        )

    }
}