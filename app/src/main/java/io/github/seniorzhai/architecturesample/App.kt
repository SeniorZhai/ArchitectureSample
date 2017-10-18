package io.github.seniorzhai.architecturesample

import android.app.Application
import android.content.Context

class App : Application() {
    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        // 注入AppModule ApiServiceModule
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        operator fun get(context: Context): App = context.applicationContext as App
    }
}
