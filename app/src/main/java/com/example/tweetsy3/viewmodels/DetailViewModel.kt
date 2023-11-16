package com.example.tweetsy3.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsy3.model.TweetsListItem
import com.example.tweetsy3.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: TweetsRepository) : ViewModel() {

    val tweets: StateFlow<List<TweetsListItem>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            repository.getTweets("motivation")
        }
    }
}