package io.github.seniorzhai.architecturesample.ui

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface UserActivityCompoent {
    fun inject(activity: UserActivity)
}
