package com.certified.rickmorty.data.network

import com.certified.rickmorty.data.model.CharacterResponse
import retrofit2.http.GET

interface RickMortyApiService {

    @GET("api/character")
    suspend fun getCharacters(): CharacterResponse

//        @GET("character/{id}")
//        suspend fun getCharacter(@Path("id") id: Int): Response<CharacterResponse>
//
//        @GET("location")
//        suspend fun getLocations(): Response<LocationResponse>
//
//        @GET("location/{id}")
//        suspend fun getLocation(@Path("id") id: Int): Response<LocationResponse>
//
//        @GET("episode")
//        suspend fun getEpisodes(): Response<EpisodeResponse>
//
//        @GET("episode/{id}")
//        suspend fun getEpisode(@Path("id") id: Int): Response<EpisodeResponse>

}