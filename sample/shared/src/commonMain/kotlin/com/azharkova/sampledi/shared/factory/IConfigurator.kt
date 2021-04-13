package com.azharkova.sampledi.shared.factory

import com.azharkova.sampledi.shared.base.IInteractor
import com.azharkova.sampledi.shared.base.IView
import com.azharkova.sampledi.shared.movieslist.IMoviesListView
import com.azharkova.sampledi.shared.movieslist.MoviesListConfigurator

interface IConfigurator {
    fun create(view: IView):IInteractor?
}

class ModuleConfig {
    companion object {
        val instance = ModuleConfig()
    }

    fun config(view: IView):IInteractor? {
         if (view is IMoviesListView) {
             return MoviesListConfigurator.instance.create(view)
         }
        return null
    }
}