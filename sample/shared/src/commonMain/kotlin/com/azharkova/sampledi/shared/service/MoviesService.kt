package com.azharkova.sampledi.shared.service

import com.azharkova.sampledi.shared.data.MoviesList
import com.azharkova.sampledi.shared.network.Configuration
import com.azharkova.sampledi.shared.network.NetworkClient

class MoviesService(private val networkClient: NetworkClient?) {

    suspend fun loadMovies(): MoviesList? {
        val url = "discover/movie?api_key=${Configuration.API_KEY}&page=1&sort_by=popularity.desc"
        return networkClient?.loadContentData(url)
    }

    suspend fun searchMovies(query: String): MoviesList? {
        val url = "search/movie?api_key=${Configuration.API_KEY}&page=1&query=${query}"
        return networkClient?.loadContentData(url)
    }
}
