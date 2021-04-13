package com.azharkova.sampledi.shared.config


import com.azharkova.di.scope.ScopeType
import com.azharkova.sampledi.shared.di.DIManager
import com.azharkova.sampledi.shared.network.NetworkClient
import com.azharkova.sampledi.shared.service.MoviesService

class ConfigurationApp {
val appContainer: DIManager = DIManager()

   init {
       setup()
   }

    fun setup() {
        appContainer.addToScope(ScopeType.Container,NetworkClient::class) {
            NetworkClient()
        }
        appContainer.addToScope(ScopeType.Container,MoviesService::class) {
            val nc = appContainer.resolve<NetworkClient>(NetworkClient::class) as? NetworkClient
            MoviesService(nc)
        }
    }
}