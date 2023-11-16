package com.example.tweetsy3.repository

import com.example.tweetsy3.api.TweetsyAPI
import com.example.tweetsy3.model.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI){

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>              //list string because categories is returned as string
     get() = _categories
    suspend fun getCategories(){
        val response = tweetsyAPI.getCategories()
        if(response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!)
        }
    }

    private val _tweets = MutableStateFlow<List<TweetsListItem>>(emptyList())
    val tweets : StateFlow<List<TweetsListItem>>
     get() = _tweets
    suspend fun getTweets(category: String){
        val response = tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}