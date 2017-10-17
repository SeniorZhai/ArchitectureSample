package io.github.seniorzhai.architecturesample.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import io.github.seniorzhai.architecturesample.Injection
import io.github.seniorzhai.architecturesample.di.ActivityScope

@Module
class UserModule(private val context: AppCompatActivity) {
    @Provides
    @ActivityScope
    internal fun provideUserViewModel(): UserViewModel {
        return ViewModelProviders
                .of(context, Injection.provideViewModelFactory(context))
                .get(UserViewModel::class.java)
    }
}
