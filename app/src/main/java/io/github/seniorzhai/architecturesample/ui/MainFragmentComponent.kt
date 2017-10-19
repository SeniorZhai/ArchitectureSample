package io.github.seniorzhai.architecturesample.ui

import dagger.Component
import io.github.seniorzhai.architecturesample.AppComponent
import io.github.seniorzhai.architecturesample.di.ActivityScope

@ActivityScope
@Component(modules = arrayOf(MainFragmentModules::class), dependencies = arrayOf(AppComponent::class))
interface MainFragmentComponent {
    fun inject(searchFragment: MainFragment)
}