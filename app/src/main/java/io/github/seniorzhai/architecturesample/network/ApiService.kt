package io.github.seniorzhai.architecturesample.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {


    @GET("news/latest")
    fun getNews(): Flowable<StoriesResponse>

    @GET("news/before/{date}")
    fun getNewsBefore(@Path("date") date: String): Flowable<StoriesResponse>

}
