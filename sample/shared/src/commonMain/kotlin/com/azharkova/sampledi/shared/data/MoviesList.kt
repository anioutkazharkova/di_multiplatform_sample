package com.azharkova.sampledi.shared.data

import kotlinx.serialization.Serializable

@Serializable
data class MoviesList(val results: List<MoviesItem>)