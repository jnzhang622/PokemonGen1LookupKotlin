package com.example.pokemongen1lookup.data.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemongen1lookup.data.api.models.PokemonResultsDTO
import com.example.pokemongen1lookup.databinding.PokemonItemBinding
import java.util.*

class MainAdapter(
    private val mListener: ((pokemon: PokemonResultsDTO?) -> Unit), //
    private val dataSet: List<PokemonResultsDTO>?) :

    RecyclerView.Adapter<MainAdapter.PokemonViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PokemonViewHolder =
            PokemonViewHolder(
                PokemonItemBinding.inflate(
                    LayoutInflater.from(viewGroup.context),
                    viewGroup,
                    false
                )
            )


        override fun onBindViewHolder(viewHolder: PokemonViewHolder, position: Int) : Unit = with(viewHolder) {

            val singlePokemon = dataSet?.get(position)
            loadData(singlePokemon)
            viewHolder.itemView.setOnClickListener{mListener(singlePokemon)}
        }

        override fun getItemCount() = dataSet?.size ?: 0

        class PokemonViewHolder(private val binding: PokemonItemBinding):
            RecyclerView.ViewHolder(binding.root){
                fun loadData(singlePokemon: PokemonResultsDTO?) = with(binding){

                    if (singlePokemon != null) {
                        binding.nameTv.text = singlePokemon.name.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.getDefault()
                            ) else it.toString()
                        }
                    }
                }
            }
}
