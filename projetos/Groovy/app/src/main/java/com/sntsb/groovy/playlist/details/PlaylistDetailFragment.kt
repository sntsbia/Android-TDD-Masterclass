package com.sntsb.groovy.playlist.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sntsb.groovy.databinding.FragmentPlaylistDetailBinding
import com.sntsb.groovy.domain.model.PlaylistDetail
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlaylistDetailFragment : Fragment() {

    private var _binding: FragmentPlaylistDetailBinding? = null
    private val binding get() = _binding!!

    val args: PlaylistDetailFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: PlaylistDetailViewModelFactory

    private val viewModel by viewModels<PlaylistDetailViewModel> {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlaylistDetailBinding.inflate(inflater, container, false)

        val id = args.playlistId

        viewModel.getPlaylistDetails(id)

        initObserver()

        return binding.root
    }

    fun initObserver() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        viewModel.playlistDetails.observe(viewLifecycleOwner) { result ->
            if (result.isSuccess) {
                result.getOrNull()?.let { playlistDetails ->
                    setupUI(playlistDetails)
                    // Update other UI elements with playlist details
                } ?: run {
                    // Handle empty details case
                }
            } else {
                // Handle error case
            }
        }
    }

    private fun setupUI(playlistDetails: PlaylistDetail) {
        binding.playlistName.text = playlistDetails.name
        binding.playlistDetails.text = playlistDetails.details
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = PlaylistDetailFragment()
    }
}