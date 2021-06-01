package com.example.pokemongen1lookup.data.adapters.singlePokemonAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.MovesDTO
import com.example.pokemongen1lookup.databinding.PokemonStatItemBinding
import java.util.*

class MovesAdapter (
    private val dataSet: List<MovesDTO>?) :

    RecyclerView.Adapter<MovesAdapter.MovesViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MovesViewHolder =
        MovesViewHolder(
            PokemonStatItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )


    override fun onBindViewHolder(viewHolder: MovesViewHolder, position: Int) : Unit = with(viewHolder) {

        val singleMove = dataSet?.get(position)
        loadData(singleMove)
    }

    override fun getItemCount() = dataSet?.size ?: 0

    class MovesViewHolder(private val binding: PokemonStatItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun loadData(singleMove: MovesDTO?) = with(binding){

            if (singleMove != null) {
                binding.nameTv.text = singleMove.move.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
    }
}