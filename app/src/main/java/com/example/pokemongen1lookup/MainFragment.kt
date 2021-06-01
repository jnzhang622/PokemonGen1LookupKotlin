package com.example.pokemongen1lookup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pokemongen1lookup.data.adapters.MainAdapter
import com.example.pokemongen1lookup.data.api.models.PokemonResultsDTO
import com.example.pokemongen1lookup.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

//    companion object {
//        fun newInstance() = MainFragment()
//    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = MainFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        viewModel.pokemonGen1Info.observe(viewLifecycleOwner, {
            binding.pokemonRv.adapter =
                MainAdapter(this@MainFragment::onPokemonClick, viewModel.pokemonGen1Info.value?.results)
        })
    }

    private fun onPokemonClick(pokemon: PokemonResultsDTO?){
        if (pokemon != null) {
            viewModel.singlePokemonName = pokemon.name
            viewModel.getSinglePokemonData()

            findNavController().navigate(R.id.action_mainFragment_to_pokemonInfoFragment)
        }

    }
}