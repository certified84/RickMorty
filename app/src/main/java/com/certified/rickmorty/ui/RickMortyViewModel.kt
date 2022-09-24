package com.certified.rickmorty.ui

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.certified.rickmorty.data.model.Character
import com.certified.rickmorty.data.repository.RickMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class RickMortyViewModel @Inject constructor(private val repository: RickMortyRepository) :
    ViewModel() {

    val pagingDataFlow: Flow<PagingData<Character>>

    init {

        pagingDataFlow = getCharacters()
    }

    private fun getCharacters(): Flow<PagingData<Character>> =
        repository.getCharacters()
}