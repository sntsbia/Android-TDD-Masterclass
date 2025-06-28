package com.sntsb.groovy.playlist.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sntsb.groovy.databinding.FragmentPlaylistBinding
import com.sntsb.groovy.domain.model.Playlist
import com.sntsb.groovy.playlist.presentation.adapter.PlaylistRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlaylistFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: PlaylistViewModelFactory

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
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

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

        Log.e("PlaylistFragment", "setupList: ${playlists.size}")
        with(binding.list) {
            layoutManager = LinearLayoutManager(context)
            adapter = PlaylistRecyclerViewAdapter(playlists) { playlistId ->
                val action =
                    PlaylistFragmentDirections.actionPlaylistFragmentToPlaylistDetailFragment(
                        playlistId
                    )
                findNavController().navigate(action)
            }
            visibility = if (playlists.isNotEmpty()) {
                View.VISIBLE
            } else {
                View.GONE
            }

        }

        binding.tvEmptyList.visibility = if (playlists.isEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
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