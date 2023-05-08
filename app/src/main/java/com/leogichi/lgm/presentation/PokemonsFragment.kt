package com.leogichi.lgm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leogichi.lgm.databinding.FragmentPokemonsBinding
import com.leogichi.lgm.domain.models.Pokemon
import com.leogichi.lgm.domain.models.Pokemons
import com.leogichi.lgm.infrastructure.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class PokemonsFragment  : Fragment() {

    lateinit var binding: FragmentPokemonsBinding
    lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonsBinding.inflate(inflater)
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getPokemons("pikachu")
        lifecycleScope.launch {
            homeViewModel.pokemon.collect{
                when(it){
                    is ResultState.Error -> {}
                    is ResultState.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is ResultState.Success<*> -> {
                        binding.progressBar.isVisible = false
                        binding.list.adapter = PokemonAdapter(listOf( it.data) as List<Pokemon>)
                        binding.list.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL,false)
                    }
                    else -> {}
                }
            }
        }

    }

}
