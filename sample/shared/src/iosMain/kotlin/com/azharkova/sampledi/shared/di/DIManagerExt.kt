package com.azharkova.sampledi.shared.di

import com.azharkova.di.scope.ScopeType
import com.azharkova.di.util.register
import com.azharkova.di.util.resolve
import com.azharkova.sampledi.shared.base.IView
import com.azharkova.sampledi.shared.factory.ModuleConfig
import kotlinx.cinterop.ObjCClass
import kotlin.reflect.KClass

fun<T:Any> DIManager.register(clazz: ObjCClass, fabric: ()->T?) {
    appContainer.register(clazz, ScopeType.Graph,fabric)
}

fun<T:Any> DIManager.resolve(clazz: ObjCClass):Any? {
    return appContainer.resolve(clazz)
}
