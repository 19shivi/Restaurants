package com.example.restaurants.Adapter

import Restaurants
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurants.R

class ResturantListAdapter(private var resturantList: List<Restaurants>): RecyclerView.Adapter<ResturantListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text=resturantList[position].restaurant.name
        holder.location.text=resturantList[position].restaurant.location.address+" "+resturantList[position].restaurant.location.locality+" "+resturantList[position].restaurant.location.city

    }

    override fun getItemCount(): Int {

       return resturantList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.restname)
        val location:TextView=itemView.findViewById(R.id.address)

    }
    fun setList(list:List<Restaurants>){
        resturantList=list
        notifyDataSetChanged()
    }
}