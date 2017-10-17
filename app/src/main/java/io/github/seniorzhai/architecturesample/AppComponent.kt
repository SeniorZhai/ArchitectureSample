package io.github.seniorzhai.architecturesample

import android.location.LocationManager
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    val locationManager: LocationManager
}
