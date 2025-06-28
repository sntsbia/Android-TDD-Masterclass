package com.sntsb.groovy.playlist.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sntsb.groovy.databinding.PlaylistItemBinding
import com.sntsb.groovy.domain.model.Playlist

class PlaylistRecyclerViewAdapter(
    private val values: List<Playlist>, private val onItemClick: (String) -> Unit = { _ -> }
) : RecyclerView.Adapter<PlaylistRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            PlaylistItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val nameView: TextView = binding.tvName
        private val categoryView: TextView = binding.tvCategory
        private val imageView: ImageView = binding.ivImage
        private val playlistItemRoot: View = binding.playlistItemRoot

//        override fun toString(): String {
//            return super.toString() + " '" + nameView.text + " - " + categoryView.text + "'"
//        }

        fun bind(item: Playlist) {

            nameView.text = item.name
            categoryView.text = item.category.name
            imageView.setImageResource(item.image)

            playlistItemRoot.setOnClickListener {
                onItemClick(item.id)
            }
        }
    }

}