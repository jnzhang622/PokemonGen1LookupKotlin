package com.example.pokemongen1lookup.data.adapters.singlePokemonAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.AbilitiesDTO
import com.example.pokemongen1lookup.databinding.PokemonItemBinding
import com.example.pokemongen1lookup.databinding.PokemonStatItemBinding
import java.util.*

class AbilityAdapter(
    private val dataSet: List<AbilitiesDTO>?
) :

    RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AbilityViewHolder =
        AbilityViewHolder(
            PokemonStatItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )


    override fun onBindViewHolder(viewHolder: AbilityViewHolder, position: Int) : Unit = with(viewHolder) {

        val singleAbility = dataSet?.get(position)
        loadData(singleAbility)
    }

    override fun getItemCount() = dataSet?.size ?: 0

    class AbilityViewHolder(private val binding: PokemonStatItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun loadData(singleAbility: AbilitiesDTO?) = with(binding){

            if (singleAbility != null) {
                binding.nameTv.text = singleAbility.ability.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
    }
}