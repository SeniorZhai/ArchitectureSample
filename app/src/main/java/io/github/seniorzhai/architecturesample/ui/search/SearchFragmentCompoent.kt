package io.github.seniorzhai.architecturesample.ui.search

import dagger.Component
import io.github.seniorzhai.architecturesample.AppComponent
import io.github.seniorzhai.architecturesample.di.ActivityScope

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class))
interface SearchFragmentCompoent {
    fun inject(searchFragment: SearchFragment)
}