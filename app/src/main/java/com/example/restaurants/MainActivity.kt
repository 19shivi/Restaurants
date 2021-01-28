package com.example.restaurants

import Restaurants
import android.Manifest
import android.app.DownloadManager
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.Adapter.ResturantListAdapter
import com.example.restaurants.ViewModel.ResturantlistModelView
import java.util.EnumSet.of

class MainActivity : AppCompatActivity() {
    lateinit var adapter:ResturantListAdapter
     lateinit var list:List<Restaurants>

     lateinit var searchView: SearchView
  lateinit   var viewModel:ResturantlistModelView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView=findViewById(R.id.recyclerView) as RecyclerView
        val linearLayoutManager:LinearLayoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
        adapter= ResturantListAdapter(mutableListOf())
        recyclerView.adapter=adapter
        searchView=findViewById(R.id.searchView) as SearchView

        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if (p0 != null) {
                        viewModel.makeSearchApiCall(p0)
                    }
                    else
                        viewModel.makeApiCall(82.973915,25.317644,100000.0)
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    if (p0 != null) {
                        viewModel.makeSearchApiCall(p0)
                    }
                    else
                        viewModel.makeApiCall(82.973915,25.317644,100000.0)
                    return false
                }

            }
        )
        viewModel=ViewModelProvider(this).get(ResturantlistModelView::class.java)
        viewModel.DataObserver().observe(this,object: Observer<List<Restaurants>>{
            override fun onChanged(t: List<Restaurants>?) {
                     if(t!=null) {
                         list = t!!

                         adapter.setList(t)
                         Log.v("size", t.size.toString())
                     }

            }

        } )
        viewModel.makeApiCall(72.877655,19.075983,100000.0)

    }




}
