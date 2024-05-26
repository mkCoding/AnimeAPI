package com.hfad.animeapi.data.repository

import com.hfad.animeapi.data.api.ApiDetails
import com.hfad.animeapi.data.api.ApiEndpoints
import com.hfad.animeapi.data.model.CharactersModel
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(private val apiEndpoints:ApiEndpoints):ApiRepository {

    override suspend fun getCharacters(): CharactersModel = apiEndpoints.getCharacters()

}