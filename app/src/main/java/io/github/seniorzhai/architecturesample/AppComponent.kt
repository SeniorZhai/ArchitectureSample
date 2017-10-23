package io.github.seniorzhai.architecturesample

import dagger.Component
import io.github.seniorzhai.architecturesample.db.ZhihuDb
import io.github.seniorzhai.architecturesample.network.ApiService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    val apiService: ApiService
    val zhihuDb: ZhihuDb
}
