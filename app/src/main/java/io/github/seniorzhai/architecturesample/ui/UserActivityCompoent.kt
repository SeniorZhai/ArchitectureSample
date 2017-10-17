package io.github.seniorzhai.architecturesample.ui

import dagger.Component
import io.github.seniorzhai.architecturesample.di.ActivityScope

@ActivityScope
@Component(modules = arrayOf(UserModule::class))
interface UserActivityCompoent {
    fun inject(activity: UserActivity)
}
