package com.example.tweetsy3.api

import com.example.tweetsy3.model.TweetsListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/654931bf54105e766fcc4762?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<TweetsListItem>> //dynamic header

    @GET("/v3/b/654931bf54105e766fcc4762?meta=false")
    @Headers("X-JSON-Path:tweets..category")  //static header
    suspend fun getCategories(): Response<List<String>>
}