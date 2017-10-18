package io.github.seniorzhai.architecturesample.ui

import dagger.Component
import io.github.seniorzhai.architecturesample.AppComponent
import io.github.seniorzhai.architecturesample.di.ActivityScope

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface MainFragmentCompoent {
    fun inject(searchFragment: MainFragment)
}