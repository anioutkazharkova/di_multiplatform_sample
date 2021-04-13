package com.example.movies.ui.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.sampledi.androidApp.R
import com.azharkova.sampledi.shared.data.MoviesItem
import com.example.movies.ui.util.loadImage

class MovieItemViewHolder (inflater: LayoutInflater, container: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movies,container,false)) {
    private  var image: ImageView? = null
    private var titleText: TextView? = null
    private  var overviewText: TextView? = null

    var tag: Int = 0
    set(value) {
        itemView.tag = value
        field = value
    }

    init {
        image = itemView.findViewById<ImageView>(R.id.image)
        titleText = itemView.findViewById<TextView>(R.id.title_text)
        overviewText = itemView.findViewById<TextView>(R.id.overview_text)
    }

    fun bindItem(item: MoviesItem) {
        titleText?.text = item.title
        overviewText?.text = item.overview
        image?.loadImage(item.imagePath())
    }
}