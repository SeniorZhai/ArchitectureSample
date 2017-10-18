package io.github.seniorzhai.architecturesample.network

import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {


    @GET("news/latest")
    fun getNews():Flowable<StoriesResponse>

}
