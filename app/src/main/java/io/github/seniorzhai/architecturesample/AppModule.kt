package io.github.seniorzhai.architecturesample

import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule internal constructor(private val context: Context) {

    @Provides
    @Singleton
    fun provideLocationMananger(): LocationManager {
        return context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }
}
