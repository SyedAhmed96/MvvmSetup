package com.ahmed.mvvmsetup.presentation.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mvvmsetup.Movie
import com.ahmed.mvvmsetup.databinding.ListItemBinding
import com.ahmed.mvvmsetup.utils.ImageLoadUtil

class MoviesListRecyclerAdapter: RecyclerView.Adapter<MoviesListRecyclerAdapter.ViewHolder>() {

    private lateinit var binding: ListItemBinding
    private var moviesList: List<Movie>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTv.text = moviesList?.get(position)?.name
        moviesList?.get(position)?.imageUrl?.let {
            ImageLoadUtil.loadImageWithoutPlaceHolder(it, holder.thumbnailImageView)
        }
    }

    override fun getItemCount(): Int {
        return moviesList?.size ?: 0
    }

    fun updateData(list: List<Movie>?){
        moviesList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
            var nameTv: TextView
            var thumbnailImageView: ImageView

            init {
                nameTv = binding.tvName
                thumbnailImageView = binding.iv
            }
    }

}