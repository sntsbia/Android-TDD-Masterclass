package com.sntsb.groovy.playlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sntsb.groovy.data.model.Playlist
import com.sntsb.groovy.databinding.FragmentPlaylistBinding
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
                    setupList(binding.list, playlists)
                } ?: run {
                    // Handle empty list case
                    setupList(binding.list, emptyList())
                }
            } else {
                // Handle error case
                setupList(binding.list, emptyList())
            }
        }
    }

    private fun setupList(view: View?, playlists: List<Playlist>) {
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