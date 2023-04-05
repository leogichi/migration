package com.leogichi.lgm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.leogichi.lgm.R
import com.leogichi.lgm.domain.models.Pokemon

class PokemonAdapter(val pokemons: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
            PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_cell_pokemon,parent,false))


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(pokemons[position])
    }

    override fun getItemCount(): Int = pokemons.size

    inner class PokemonViewHolder(item: View): ViewHolder(item) {
        fun onBind(pokemon: Pokemon){
                //TODO manejar como bindear
        }
    }

}