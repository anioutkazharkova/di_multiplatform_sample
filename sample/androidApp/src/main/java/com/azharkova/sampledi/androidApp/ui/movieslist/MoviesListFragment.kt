package com.example.movies.ui.movieslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azharkova.sampledi.androidApp.App
import com.example.movies.ui.adapter.MoviesAdapter
import com.azharkova.sampledi.androidApp.R
import com.azharkova.sampledi.androidApp.ui.interactors
import com.azharkova.sampledi.shared.data.MoviesItem
import com.azharkova.sampledi.shared.movieslist.IMoviesListInteractor
import com.azharkova.sampledi.shared.movieslist.IMoviesListView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListFragment : Fragment(), IMoviesListView {

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    private var adapter :MoviesAdapter? = null
    private var list: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_list_fragment, container, false)?.also {
            list = it?.findViewById<RecyclerView>(R.id.list)
            list?.layoutManager = LinearLayoutManager(this.activity)
            this.interactor = App.container.resolve(this) as IMoviesListInteractor?
            adapter = MoviesAdapter(this::onMovieClick)
        }
    }

    private fun onMovieClick(index: Int) {
        TODO("Not yet implemented")
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        //this.interactor?.attachView()
        //this.interactor?.loadMovies()

        inter?.attachView()
        inter?.loadMovies()
    }

    override fun onPause() {
        this.interactor?.detachView()
        super.onPause()
    }

    val inter: IMoviesListInteractor? by interactors(this)

    override var interactor: IMoviesListInteractor? = null

    override fun setup(items: List<MoviesItem>) {
        adapter?.updateItems(items)
        list?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }
}