package com.azharkova.sampledi.shared.util

import kotlin.coroutines.CoroutineContext


expect val uiDispatcher: CoroutineContext
expect val ioDispatcher: CoroutineContext