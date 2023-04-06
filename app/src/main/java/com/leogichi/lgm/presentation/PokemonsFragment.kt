package com.leogichi.lgm.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leogichi.lgm.R
import com.leogichi.lgm.databinding.FragmentPokemonsBinding
import com.leogichi.lgm.domain.PokemonProvider
import com.leogichi.lgm.infrastructure.HomeViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonsFragment : Fragment() {

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
        homeViewModel.getPokemons()
        homeViewModel.pokemons.observe(viewLifecycleOwner){
            binding.list.adapter = PokemonAdapter(it)
            binding.list.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL,false)
        }

    }
}