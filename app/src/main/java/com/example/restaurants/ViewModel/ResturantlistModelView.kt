package com.example.restaurants.ViewModel

import Restaurant
import Restaurants
import androidx.lifecycle.ViewModel
import com.example.restaurants.Networks.ApiService
import com.example.restaurants.Networks.RetrofitInstance
import retrofit2.Call
import Result
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Callable

class ResturantlistModelView : ViewModel() {
      var mutableData: MutableLiveData<List<Restaurants>> =MutableLiveData<List<Restaurants>>()
    fun DataObserver():MutableLiveData<List<Restaurants>>{
        return mutableData
    }
    fun makeApiCall(longitude: Double,latitude:Double,Radius:Double,)
    {
        val apiService:ApiService=RetrofitInstance.buildService(ApiService::class.java)
        val call:Call<Result> =apiService.getAllResturants(latitude = latitude,longitude = longitude,radius = Radius )
        call.enqueue(object: Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                mutableData.postValue(response.body()?.restaurants)
                Log.v("api",response.body().toString())

            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
              mutableData.postValue(null)
                Log.v("error",t.toString())
            }

        })
    }
    fun makeSearchApiCall(query:String)
    {
        val apiService:ApiService=RetrofitInstance.buildService(ApiService::class.java)
        val call:Call<Result> =apiService.getSearchResult(query=query )
        call.enqueue(object: Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                mutableData.postValue(response.body()?.restaurants)
                Log.v("api",response.body().toString())

            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                mutableData.postValue(null)
                Log.v("error",t.toString())
            }

        })
    }
}
