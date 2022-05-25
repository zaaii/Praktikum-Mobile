package com.zai.movieku.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zai.movieku.R
import com.zai.movieku.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMoviesBinding.inflate(inflater)
        viewModel.getMovieList()
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = MovieAdapter(MoviesListener { movies ->
            viewModel.onMovieClicked(movies)
            findNavController()
                .navigate(R.id.action_moviesFragment_to_movieDetailsFragment)
        })

        (activity as AppCompatActivity).supportActionBar?.title = "MovieKu"

        return binding.root
    }
}