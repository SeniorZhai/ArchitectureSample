package io.github.seniorzhai.architecturesample

import android.location.LocationManager
import dagger.Component
import io.github.seniorzhai.architecturesample.network.ApiService
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    val locationManager: LocationManager
    val apiService: ApiService
}
