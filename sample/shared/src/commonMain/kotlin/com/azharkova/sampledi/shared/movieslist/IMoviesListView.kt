package com.azharkova.sampledi.shared.movieslist

import com.azharkova.sampledi.shared.base.IView
import com.azharkova.sampledi.shared.data.MoviesItem

interface IMoviesListView : IView {
    var interactor: IMoviesListInteractor?

    fun setup(items: List<MoviesItem>)
}