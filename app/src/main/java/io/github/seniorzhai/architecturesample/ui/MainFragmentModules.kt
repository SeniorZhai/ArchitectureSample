package io.github.seniorzhai.architecturesample.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides
import io.github.seniorzhai.architecturesample.di.ActivityScope

/**
 * Created by zhai on 2017/10/19.
 */
@Module
class MainFragmentModules internal constructor(private val context: FragmentActivity) {

    @Provides
    @ActivityScope
    fun provideViewModel(): MainFragmentViewModel =
            ViewModelProviders.of(context).get(MainFragmentViewModel::class.java)

}