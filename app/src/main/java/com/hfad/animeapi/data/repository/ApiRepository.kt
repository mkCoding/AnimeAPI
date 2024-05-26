package com.hfad.animeapi.data.repository

import com.hfad.animeapi.data.model.CharactersModel

//Method to be implemented by ApiRepositoryImpl
interface ApiRepository {
    suspend fun getCharacters(): CharactersModel
}