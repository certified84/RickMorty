package com.certified.rickmorty.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.certified.rickmorty.data.model.Character

@Composable
fun ListContent(items: LazyPagingItems<Character>) {
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