package com.solodilov.coincompose.app

import android.app.Application
import com.solodilov.coin.di.coinModule
import com.solodilov.data.di.dataModule
import com.solodilov.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    coinModule,
                )
            )
        }
    }
}