package io.github.seniorzhai.architecturesample.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String): Flowable<RepoSearchResponse>

}
