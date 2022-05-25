package com.zai.movieku.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.zai.movieku.databinding.MovieRowBinding
import com.zai.movieku.network.Movie

class MovieAdapter(private val clickListener: MoviesListener) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DiffCallback)
{
        class MovieViewHolder(
            var binding: MovieRowBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun bind(clickListener: MoviesListener, movie: Movie) {
                binding.movie = movie
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
        }

    companion object DiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.release_date == newItem.release_date && oldItem.overview == newItem.overview && oldItem.poster_path == newItem.poster_path
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(
            MovieRowBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(clickListener, movie)
    }

}
class MoviesListener(val clickListener: (movie: Movie) -> Unit) {
    fun onClick(movie: Movie) = clickListener(movie)
}