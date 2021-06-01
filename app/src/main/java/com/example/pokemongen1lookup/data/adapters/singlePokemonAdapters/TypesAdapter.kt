package com.example.pokemongen1lookup.data.adapters.singlePokemonAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.TypeDTO
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.TypesDTO
import com.example.pokemongen1lookup.databinding.PokemonStatItemBinding
import java.util.*

class TypesAdapter (
    private val dataSet: List<TypesDTO>?) :

    RecyclerView.Adapter<TypesAdapter.TypesViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TypesViewHolder =
        TypesViewHolder(
            PokemonStatItemBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )


    override fun onBindViewHolder(viewHolder: TypesViewHolder, position: Int) : Unit = with(viewHolder) {

        val singleType = dataSet?.get(position)
        loadData(singleType)
    }

    override fun getItemCount() = dataSet?.size ?: 0

    class TypesViewHolder(private val binding: PokemonStatItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun loadData(singleType: TypesDTO?) = with(binding){

            if (singleType != null) {
                binding.nameTv.text = singleType.type.name.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
    }
}