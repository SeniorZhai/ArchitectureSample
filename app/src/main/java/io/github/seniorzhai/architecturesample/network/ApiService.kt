package io.github.seniorzhai.architecturesample.network

import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("/ip")
    fun ip(): Flowable<IP>
}
