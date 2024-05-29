package com.hfad.animeapi.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hfad.animeapi.data.model.CharactersModel
import com.hfad.animeapi.data.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(private val repository: ApiRepository):ViewModel() {

    //If json response starts with an Object use this -> MutableLiveData<Model>
    //If json response starts with an Array use this -> MutableLiveData<ArrayList<Model>>

    private val _charactersList  = MutableLiveData<CharactersModel>()
    val charactersList:LiveData<CharactersModel> = _charactersList

    init {
        //getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            val allCharacters = repository.getCharacters()

            if(allCharacters!=null){
                //this is very important for updating the view
                _charactersList.postValue(allCharacters)
            }
        }

    }

}