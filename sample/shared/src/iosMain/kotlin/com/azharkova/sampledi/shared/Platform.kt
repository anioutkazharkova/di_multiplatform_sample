package com.azharkova.sampledi.shared


import com.azharkova.di.scope.ScopeType
import com.azharkova.di.util.register
import com.azharkova.di.util.resolve
import com.azharkova.sampledi.shared.config.ConfigurationApp
import kotlinx.cinterop.ObjCClass
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

