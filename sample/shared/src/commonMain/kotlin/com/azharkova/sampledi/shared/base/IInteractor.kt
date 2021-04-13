package com.azharkova.sampledi.shared.base

import com.azharkova.sampledi.shared.di.DIManager

interface IInteractor {
    fun setup(di: DIManager)

    fun attachView()

    fun detachView()
}