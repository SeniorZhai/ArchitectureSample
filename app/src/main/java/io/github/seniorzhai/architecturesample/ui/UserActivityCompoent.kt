package io.github.seniorzhai.architecturesample.ui

import dagger.Component
import io.github.seniorzhai.architecturesample.AppComponent
import io.github.seniorzhai.architecturesample.di.ActivityScope

@ActivityScope
@Component(modules = arrayOf(UserModule::class), dependencies = arrayOf(AppComponent::class))
interface UserActivityCompoent {
    fun inject(activity: UserActivity)
}
