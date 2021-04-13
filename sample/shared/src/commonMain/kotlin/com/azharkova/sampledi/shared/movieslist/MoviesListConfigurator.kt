package com.azharkova.sampledi.shared.movieslist

import com.azharkova.sampledi.shared.base.IInteractor
import com.azharkova.sampledi.shared.base.IView
import com.azharkova.sampledi.shared.factory.IConfigurator

class MoviesListConfigurator : IConfigurator {
    companion object {
        val instance = MoviesListConfigurator()
    }

    override fun create(view: IView): IInteractor? {
        val interactor: IMoviesListInteractor = MoviesListInteractor()
        val presenter = MoviesListPresenter()
        interactor.presenter = presenter
        presenter.view = view as? IMoviesListView
        return interactor
    }
}

