package com.example.hiltdagger

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltdagger.Model.RecyclerData
import com.example.hiltdagger.Network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {

    lateinit var liveDataList: MutableLiveData<List<RecyclerData>>
    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<RecyclerData>>{
        return liveDataList
    }

    fun loadListOfData() {
        repository.makeApiCall("ny", liveDataList)
    }
}