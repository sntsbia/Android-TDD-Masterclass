package com.sntsb.groovy.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.data.repository.PlaylistRepositoryImpl
import com.sntsb.groovy.databinding.FragmentPlaylistBinding

class PlaylistFragment : Fragment() {

    private val repository = PlaylistRepositoryImpl()

    private val viewModelFactory = PlaylistViewModelFactory(repository)

    private val viewModel by viewModels<PlaylistViewModel> {
        viewModelFactory
    }

    private var _binding: FragmentPlaylistBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistBinding.inflate(inflater, container, false)

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        viewModel.playlists.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                it.getOrNull()?.let { playlists ->
                    setupList(playlists)
                } ?: run {
                    // Handle empty list case
                    setupList(emptyList())
                }
            } else {
                // Handle error case
                setupList(emptyList())
            }
        }
    }

    private fun setupList(playlists: List<Playlist>) {
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = PlaylistRecyclerViewAdapter(playlists)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = PlaylistFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}