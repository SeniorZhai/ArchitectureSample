package io.github.seniorzhai.architecturesample.network

data class StoriesResponse constructor(
        var date: String,
        var stories: List<Story>)