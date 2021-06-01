package com.example.pokemongen1lookup

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemongen1lookup.data.api.models.PokemonGen1ResponseDTO
import com.example.pokemongen1lookup.data.api.models.singlepokemonmodels.SinglePokemonResponseDTO
import com.example.pokemongen1lookup.repos.PokemonRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val pokemonRepo: PokemonRepo by lazy{
        PokemonRepo()
    }

    private var _pokemonGen1Info = MutableLiveData<PokemonGen1ResponseDTO>()
    val pokemonGen1Info : LiveData<PokemonGen1ResponseDTO> get() = _pokemonGen1Info

    private var _singlePokemonInfo = MutableLiveData<SinglePokemonResponseDTO>()
    val singlePokemonInfo : LiveData<SinglePokemonResponseDTO> get() = _singlePokemonInfo

    init{
        getPokemonGen1Data()
    }

    private fun getPokemonGen1Data() =
        disposable.add(
            pokemonRepo.getGen1Pokemon().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetPokemonSuccess, this::onGetPokemonError)
        )

    var singlePokemonName = ""
    fun getSinglePokemonData() =
        disposable.add(
            pokemonRepo.getSinglePokemon(singlePokemonName).subscribeOn(Schedulers.io()) // rxJava - creates a background thread
                .observeOn(AndroidSchedulers.mainThread()) // rxJava - updating mainthread
                .subscribe(this::onGetSinglePokemonSuccess, this::onGetPokemonError)
        )

    private fun onGetPokemonSuccess(pokemonInfo: PokemonGen1ResponseDTO) {
        _pokemonGen1Info.value = pokemonInfo
    }

    private fun onGetSinglePokemonSuccess(pokemonInfo: SinglePokemonResponseDTO) {
        _singlePokemonInfo.value = pokemonInfo
    }

    private fun onGetPokemonError(e: Throwable) {
        e.message.let { Log.d(TAG, it.toString()) }
    }

    companion object {
        private val TAG = MainViewModel::class.java.name
    }
}