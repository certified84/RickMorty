package com.certified.rickmorty.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import com.certified.rickmorty.data.model.Character

@Composable
fun CharacterGrid(items: LazyPagingItems<Character>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(count = items.itemCount, key = { items[it]?.id ?: it }) { index ->
            items[index]?.let {
                ItemCharacter(character = it)
            }
        }
    }
}