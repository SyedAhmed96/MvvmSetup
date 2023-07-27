package com.ahmed.mvvmsetup.utils

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.mvvmsetup.Movie
import com.ahmed.mvvmsetup.presentation.login.MoviesListRecyclerAdapter


/** A static binding adapter method which takes two input param view and value and is reponsible for showing or hiding view
 * @param view
 * @param value */
@BindingAdapter("app:hide")
fun showIfFalse(view: View, value: Boolean ){
    view.visibility = if (!value) View.VISIBLE else View.INVISIBLE
}
// list: List<Movie>?
/** A static binding adapter method which takes two input param and call update data method on adapter
 * @param recyclerView
 * @param list*/
@BindingAdapter("app:listItems")
fun bindItemRecyclerView(recyclerView: RecyclerView, livelist: MutableLiveData<List<Movie>>) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateData(livelist.value)
}

/** A method which takes input a param and return adapter*/
private fun getOrCreateAdapter(recyclerView: RecyclerView): MoviesListRecyclerAdapter {
    // Return already created recyclerview with type checking is symbollistrecycleradapter
    return if (recyclerView.adapter != null && recyclerView.adapter is MoviesListRecyclerAdapter) {
        // Casting recyclerView.adapter as SymbolListRecyclerAdapter
        recyclerView.adapter as MoviesListRecyclerAdapter
    }
    // Create a new adapter object and setting it to recyclerView.adapter
    else {
        val bindableRecyclerAdapter = MoviesListRecyclerAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}