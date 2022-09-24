package com.certified.rickmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.certified.rickmorty.data.model.Character
import com.certified.rickmorty.data.network.RickMortyApiService
import com.certified.rickmorty.data.paging.RickMortyPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickMortyRepository @Inject constructor(private val api: RickMortyApiService) {

    fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = true),
            pagingSourceFactory = { RickMortyPagingSource(api) }
        ).flow
    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}