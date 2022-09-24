package com.certified.rickmorty.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.certified.rickmorty.data.model.Character
import com.certified.rickmorty.data.network.RickMortyApiService
import com.certified.rickmorty.data.repository.RickMortyRepository.Companion.NETWORK_PAGE_SIZE
import retrofit2.HttpException
import java.io.IOException

private const val RICK_MORTY_STARTING_PAGE_INDEX = 1

class RickMortyPagingSource(
    private val service: RickMortyApiService
) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val position = params.key ?: RICK_MORTY_STARTING_PAGE_INDEX
        return try {
            val response = service.getCharacters(position)
            val characters = response.results
            val nextKey = if (characters.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = characters,
                prevKey = if (position == RICK_MORTY_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    // The refresh key is used for the initial load of the next PagingSource, after invalidation
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}