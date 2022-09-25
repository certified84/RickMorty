package com.certified.rickmorty.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
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

    val characters: LiveData<PagingData<Character>>

    init {
        characters = getCharacters().asLiveData()
    }

    private fun getCharacters(): Flow<PagingData<Character>> =
        repository.getCharacters()
}