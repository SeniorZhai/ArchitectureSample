package io.github.seniorzhai.architecturesample.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.MainThread
import io.github.seniorzhai.architecturesample.network.Story

class MainFragmentViewModel : ViewModel() {

    var storyList: MutableLiveData<List<Story>> = MutableLiveData()

    @MainThread
    fun setStoryList(stories: List<Story>) {
        storyList.value = stories
    }
}
