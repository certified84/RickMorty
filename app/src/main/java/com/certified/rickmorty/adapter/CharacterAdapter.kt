package com.certified.rickmorty.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.certified.rickmorty.data.model.Character
import com.certified.rickmorty.databinding.ItemCharacterBinding

class CharacterAdapter : PagingDataAdapter<Character, CharacterAdapter.ViewHolder>(diffCallback) {

    private lateinit var listener: OnItemClickedListener

    inner class ViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        var visible = false

        fun bind(character: Character?) {
            binding.character = character
            binding.tvInfo.text = "${character?.gender} - ${character?.status}"
            binding.visible = visible
        }

        init {
            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(getItem(position))
                    visible = !visible
                    binding.visible = visible
                }
            }
        }
    }

    interface OnItemClickedListener {
        fun onItemClick(character: Character?)
    }

    fun setOnItemClickedListener(listener: OnItemClickedListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }
        }
    }
}