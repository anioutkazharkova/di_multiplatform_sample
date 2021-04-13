package com.example.movies.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.sampledi.shared.data.MoviesItem
import com.example.movies.ui.viewholder.MovieItemViewHolder

class MoviesAdapter(private val onItemClick: (Int) -> Unit) : RecyclerView.Adapter<MovieItemViewHolder>() {
    private var items: ArrayList<MoviesItem> = arrayListOf()

    fun updateItems(items: List<MoviesItem>) {
        this.items = arrayListOf()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(LayoutInflater.from(parent.context),parent)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
        holder.tag = position
        holder.itemView.setOnClickListener {
            onItemClick(it.tag as Int)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}