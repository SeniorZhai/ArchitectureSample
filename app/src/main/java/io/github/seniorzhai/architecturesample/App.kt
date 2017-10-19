package io.github.seniorzhai.architecturesample

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary

class App : Application() {
    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        // 注入AppModule ApiServiceModule
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        if (LeakCanary.isInAnalyzerProcess(this)) return
        LeakCanary.install(this)
        Stetho.initializeWithDefaults(this)
    }

    companion object {
        operator fun get(context: Context): App = context.applicationContext as App
    }
}
