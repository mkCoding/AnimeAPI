package com.hfad.animeapi.data.api

import com.hfad.animeapi.data.model.CharactersModel
import retrofit2.http.GET

//Specify the Api Endpoint abstract methods with Annotations
interface ApiEndpoints {

    @GET(ApiDetails.ENDPOINT)
    suspend fun getCharacters():CharactersModel
}