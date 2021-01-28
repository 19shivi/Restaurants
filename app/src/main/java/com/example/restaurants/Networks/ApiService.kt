package com.example.restaurants.Networks
import Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Content-Type: application/json","user-key:"+"1b3c8b37ea96785391fa55c288ac385c")
    @GET("search")
    fun getAllResturants( @Query( "lat")latitude:Double, @Query("lon")longitude:Double,
                         @Query("radius")radius:Double):Call<Result>
    @Headers("Content-Type: application/json","user-key:"+"1b3c8b37ea96785391fa55c288ac385c")
    @GET("search")
    fun getSearchResult(@Query("q")query:String):Call<Result>
}