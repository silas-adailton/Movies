package br.com.oliveira.silas.movies.ui.main.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.oliveira.silas.movies.R
import br.com.oliveira.silas.movies.databinding.ItemListMoviesBinding
import br.com.oliveira.silas.movies.domain.Movie
import java.util.ArrayList

class MovieAdapter(private val listMovies: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind :ItemListMoviesBinding = DataBindingUtil
                .inflate(LayoutInflater
                        .from(parent.context),
                        R.layout.item_list_movies, parent, false)

        return ViewHolder(bind)
    }

    override fun getItemCount() = listMovies.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.movie = listMovies[position]
        holder.binding.executePendingBindings()
    }

    inner class ViewHolder(val binding: ItemListMoviesBinding) : RecyclerView.ViewHolder(binding.root)
}