package com.certified.rickmorty.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.certified.rickmorty.adapter.CharacterAdapter
import com.certified.rickmorty.data.model.Character
import com.certified.rickmorty.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RickMortyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CharacterAdapter()
        adapter.setOnItemClickedListener(object : CharacterAdapter.OnItemClickedListener {
            override fun onItemClick(character: Character?) {

            }
        })

        viewModel.characters.observe(this) {
            adapter.submitData(lifecycle, it)
        }

        binding.recyclerViewCharacters.adapter = adapter
        binding.recyclerViewCharacters.layoutManager =
            StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
