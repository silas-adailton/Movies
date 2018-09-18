package com.oliveira.silas.cad.binding

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliveira.silas.cad.ui.main.movie.MovieAdapter
import com.oliveira.silas.domain.user.User
import com.oliveira.silas.cad.ui.main.user.UserAdapter
import com.oliveira.silas.domain.movies.Movie

object bindAdapters {
    @JvmStatic
    @BindingAdapter("loadRecyclerView")
    fun loadRecyclerView(recyclerView: RecyclerView, listUser: List<User>?) {
        val viewAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)

        viewAdapter = UserAdapter(listUser!!)
        recyclerView.adapter = viewAdapter
    }

    @JvmStatic
    @BindingAdapter("loadRecyclerViewMovies")
    fun loadRecyclerViewMovies(recyclerView: RecyclerView, listMovies: List<Movie>?) {
        val viewAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolder>
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)

        viewAdapter = MovieAdapter(listMovies!!)
        recyclerView.adapter = viewAdapter
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(imageUrl: String?) {
        Glide.with(this)
                .load(imageUrl)
                .into(this)
    }

//    fun loadImage(imageView: ImageView, imageUrl: String?) {
//        Glide.with(imageView.context)
//                .load(imageUrl)
//                .into(imageView)
//    }

    @JvmStatic
    @BindingAdapter("loading")
    fun loading(view: View, value: Boolean) {
        view.visibility = if (value) View.VISIBLE else View.GONE
    }
}