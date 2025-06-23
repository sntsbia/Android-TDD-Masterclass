package com.sntsb.groovy.presentation.placeholder

import com.sntsb.groovy.data.model.Playlist
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    val ITEMS: MutableList<Playlist> = ArrayList()

    val ITEM_MAP: MutableMap<String, Playlist> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Playlist) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createPlaceholderItem(position: Int): Playlist {
        return Playlist(position.toString(), "Item $position", makeDetails(position), -1)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..<position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

}