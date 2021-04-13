package com.azharkova.sampledi.shared.movieslist

import com.azharkova.sampledi.shared.base.BaseInteractor
import com.azharkova.sampledi.shared.base.BasePresenter
import com.azharkova.sampledi.shared.base.IInteractor
import com.azharkova.sampledi.shared.data.MoviesItem
import com.azharkova.sampledi.shared.data.MoviesList
import com.azharkova.sampledi.shared.di.DIManager
import com.azharkova.sampledi.shared.service.MoviesService
import com.azharkova.sampledi.shared.util.ioDispatcher
import com.azharkova.sampledi.shared.util.uiDispatcher
import kotlinx.coroutines.launch

interface IMoviesListInteractor : IInteractor{
    var presenter: IMoviesListPresenter?
    fun loadMovies()
}

class MoviesListInteractor:BaseInteractor<IMoviesListView>(uiDispatcher),IMoviesListInteractor {
    private var moviesService: MoviesService? = null
    override var presenter: IMoviesListPresenter? = null


    private var moviesList: ArrayList<MoviesItem> = arrayListOf()

    override fun setup(di: DIManager) {
        this.moviesService = di.resolve<MoviesService>(MoviesService::class) as? MoviesService
        print(moviesService)
    }


   override fun loadMovies() {
        scope.launch {
            print(moviesService == null)
            val result = moviesService?.loadMovies()?.results
            moviesList = arrayListOf()
            moviesList.addAll(result ?: arrayListOf())
            presenter?.setup(moviesList)
        }
    }
}