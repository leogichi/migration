package com.leogichi.lgm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leogichi.lgm.R

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(item: View): RecyclerView.ViewHolder(item){
        fun onBind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cell,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return 5
    }
}