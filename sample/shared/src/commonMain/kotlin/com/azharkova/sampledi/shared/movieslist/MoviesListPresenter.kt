package com.azharkova.sampledi.shared.movieslist

import com.azharkova.sampledi.shared.base.BasePresenter
import com.azharkova.sampledi.shared.data.MoviesItem

interface IMoviesListPresenter {
    var view: IMoviesListView?

    fun setup(items: List<MoviesItem>)
}

class MoviesListPresenter: BasePresenter<IMoviesListView>(),IMoviesListPresenter {
   override var view: IMoviesListView? = null

    override fun setup(items: List<MoviesItem>) {
        this.view?.setup(items)
    }
}