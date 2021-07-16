package com.example.hiltdagger.Network

import androidx.lifecycle.MutableLiveData
import com.example.hiltdagger.Model.RecyclerData
import com.example.hiltdagger.Model.RecyclerList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance: RetroServieInstance) {
    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<RecyclerData>>) {
        val call: Call<RecyclerList> = retroInstance.getDataFromAPI(query)
        call?.enqueue(object : Callback<RecyclerList> {
            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items!!)
            }
        })

    }

}