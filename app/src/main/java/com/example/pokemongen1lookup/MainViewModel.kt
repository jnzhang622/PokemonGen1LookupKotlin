package com.example.pokemongen1lookup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemongen1lookup.data.api.models.PokemonGen1ResponseDTO
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import com.example.pokemongen1lookup.repos.PokemonRepo
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
//    private val disposable = CompositeDisposable()
    private val pokemonRepo: PokemonRepo by lazy{
        PokemonRepo()
    }

    private var _pokemonGen1Info = MutableLiveData<PokemonGen1ResponseDTO>()
    val pokemonGen1Info get() = _pokemonGen1Info

    private var _singlePokemonInfo = MutableLiveData<SinglePokemonResponseDTO>()
    val singlePokemonInfo get() = _singlePokemonInfo

    init{
        getPokemonGen1Data()
    }

    private fun getPokemonGen1Data(){
        viewModelScope.launch {
            try {
                val getGen1Poke = async{pokemonRepo.getGen1Pokemon()}
                pokemonGen1Info.value = getGen1Poke.await().body()
            }catch (e: Exception){
                onGetPokemonError(e)
            }
        }
    }

    var singlePokemonName = ""
    fun getSinglePokemonData(){
        viewModelScope.launch {
            try {
                val getSinglePoke = async{pokemonRepo.getSinglePokemon(singlePokemonName)}
                singlePokemonInfo.value = getSinglePoke.await().body()
            }catch (e: Exception){
                onGetPokemonError(e)
            }
        }
    }

//    private fun onGetPokemonSuccess(pokemonInfo: PokemonGen1ResponseDTO) {
//        _pokemonGen1Info.value = pokemonInfo
//    }
//
//    private fun onGetSinglePokemonSuccess(pokemonInfo: SinglePokemonResponseDTO) {
//        _singlePokemonInfo.value = pokemonInfo
//    }

    private fun onGetPokemonError(e: Throwable) {
        e.message.let { Log.d(TAG, it.toString()) }
    }

    companion object {
        private val TAG = MainViewModel::class.java.name
    }
}