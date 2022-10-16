package com.azharkova.sampledi.shared.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*


expect fun createHttpClient():HttpClient

class NetworkClient {
    val httpClient = createHttpClient()

    suspend inline fun<reified T> loadData(path: String): Result<T> {
        return try {
            val result = httpClient.get(path).body<T>()
            Result.success(result)
        }catch (e: Exception) {
            Result.failure(e)
        }

    }
}