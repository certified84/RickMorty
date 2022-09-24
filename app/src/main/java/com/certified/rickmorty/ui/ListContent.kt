package com.certified.rickmorty.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.certified.rickmorty.data.model.Character

@Composable
fun ListContent(items: LazyPagingItems<Character>) {
//    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = items, key = { it.id }) { character ->
            character?.let {
                ItemCharacter(character = character)
            }
        }
    }
}

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
//        for (i in 0..items.itemCount) {
//            item(span = { GridItemSpan(maxLineSpan) }) {
//                ItemCharacter(character = items[i])
//            }
//        }
    }
}