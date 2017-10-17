package io.github.seniorzhai.architecturesample.ui;

import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhai on 2017/10/17.
 */

@Module
public class UserModule {

    private final Context context;

    public UserModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }
}
