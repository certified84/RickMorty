package com.certified.rickmorty.data.network

import com.certified.rickmorty.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {

    @GET("api/character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse

}