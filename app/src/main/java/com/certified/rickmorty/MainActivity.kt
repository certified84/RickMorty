package com.certified.rickmorty

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.certified.rickmorty.ui.CharacterGrid
import com.certified.rickmorty.ui.RickMortyViewModel
import com.certified.rickmorty.ui.theme.RickMortyTheme
import com.certified.rickmorty.ui.theme.SpaceGrotesk
import com.intuit.sdp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: RickMortyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            RickMortyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = dimensionResource(id = R.dimen._16sdp),
                                start = dimensionResource(id = R.dimen._16sdp),
                                end = dimensionResource(id = R.dimen._16sdp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Log.d(
                            "TAG",
                            "onCreate: ${viewModel.pagingDataFlow.collectAsLazyPagingItems().itemCount}"
                        )

                        Spacer(modifier = Modifier.padding(10.dp))

                        Text(
                            text = "Rick & Morty - Compose",
                            fontSize = 24.sp,
                            fontFamily = SpaceGrotesk,
                            fontWeight = FontWeight.Bold,
//                    color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.padding(16.dp))

                        CharacterGrid(items = viewModel.pagingDataFlow.collectAsLazyPagingItems())

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickMortyTheme {
        Greeting("Android")
    }
}