package com.sntsb.groovy.playlist.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sntsb.groovy.data.model.Playlist

import com.sntsb.groovy.databinding.PlaylistItemBinding

class PlaylistRecyclerViewAdapter(
    private val values: List<Playlist>
) : RecyclerView.Adapter<PlaylistRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            PlaylistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
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

//        override fun toString(): String {
//            return super.toString() + " '" + nameView.text + " - " + categoryView.text + "'"
//        }

        fun bind(item: Playlist) {

            nameView.text = item.name
            categoryView.text = item.category
            imageView.setImageResource(item.image)

            itemView.setOnClickListener {
                // Handle item click, e.g., navigate to details or play the playlist
            }
        }
    }

}