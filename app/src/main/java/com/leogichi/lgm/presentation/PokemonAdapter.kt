package com.leogichi.lgm.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.leogichi.lgm.R
import com.leogichi.lgm.databinding.ViewCellPokemonBinding
import com.leogichi.lgm.domain.models.Pokemon

class PokemonAdapter(val pokemons: List<Pokemon>): RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
            PokemonViewHolder(ViewCellPokemonBinding.inflate(LayoutInflater.from(parent.context)))


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.onBind(pokemons[position])
    }

    override fun getItemCount(): Int = pokemons.size

    class PokemonViewHolder(private val itemBinding: ViewCellPokemonBinding): ViewHolder(itemBinding.root) {
        fun onBind(pokemon: Pokemon){
            itemBinding.apply {
                pokemonName.text  = pokemon.name
            }
        }
    }

}