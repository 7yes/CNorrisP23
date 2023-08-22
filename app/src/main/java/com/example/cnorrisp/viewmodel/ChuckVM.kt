package com.example.cnorrisp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cnorrisp.domain.GetCustomUseCase
import com.example.cnorrisp.domain.GetQueryUseCase
import com.example.cnorrisp.domain.GetRandomUseCase
import com.example.cnorrisp.ui.states.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChuckVM @Inject constructor(
    private val getRandomUseCase: GetRandomUseCase,
    private val getCustomUseCase: GetCustomUseCase,
    private val getQueryUseCase: GetQueryUseCase
) : ViewModel() {

    // Random
    private var _lastRandom = MutableLiveData<String>()
    val lastRandom: LiveData<String> = _lastRandom

    private var _stateRandom = MutableLiveData<UIState>()
    val stateRandom: LiveData<UIState> = _stateRandom

    //Custom
    private var _lastCustom = MutableLiveData<String>()
    val lastCustom: LiveData<String> = _lastCustom

    private var _stateCustom = MutableLiveData<UIState>()
    val stateCustom: LiveData<UIState> = _stateCustom

    //Query
    private var _lastList = MutableLiveData<List<String>>()
    val lastList: LiveData<List<String>> = _lastList

    private var _stateList = MutableLiveData<UIState>()
    val stateList: LiveData<UIState> = _stateList

    @SuppressWarnings("TooGenericExceptionCaught")
    fun getRandom() {
        _stateRandom.postValue(UIState.Loading)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val joke = getRandomUseCase.getRandom()
                if (joke.isNotEmpty()) {
                    _stateRandom.postValue(UIState.Success)
                    _lastRandom.postValue(joke)
                } else {
                    Log.d("TAG", "getSimpleRandom: call successful but no data ")
                }
            } catch (e: Exception) {
                _stateRandom.postValue(UIState.Error(e))
            }
        }
    }

    @SuppressWarnings("TooGenericExceptionCaught")
    fun getCustom(name: String) {
        _stateCustom.postValue(UIState.Loading)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val joke = getCustomUseCase.getCustom(name)
                if (joke.isNotEmpty()) {
                    _stateCustom.postValue(UIState.Success)
                    _lastCustom.postValue(joke)

                } else {
                    Log.d("TAG", "getSimpleRandom: call successful but no data ")
                }
            } catch (e: Exception) {
                _stateCustom.postValue(UIState.Error(e))
            }
        }
    }

    @SuppressWarnings("TooGenericExceptionCaught")
    fun getQuery(query: String) {
        _stateList.postValue(UIState.Loading)
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val jokes = getQueryUseCase.getList(query)
                if (jokes.isNotEmpty()) {
                    _stateList.postValue(UIState.Success)
                    _lastList.postValue(jokes)
                    Log.d("TAG", "getQuery: jokes $jokes ")

                } else {
                    Log.d("TAG", "getSimpleRandom: call successful but no data ")
                }
            } catch (e: Exception) {
                _stateList.postValue(UIState.Error(e))
            }
        }
    }
}
