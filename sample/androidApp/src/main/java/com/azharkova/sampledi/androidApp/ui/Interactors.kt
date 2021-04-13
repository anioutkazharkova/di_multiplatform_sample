package com.azharkova.sampledi.androidApp.ui

import com.azharkova.sampledi.androidApp.App
import com.azharkova.sampledi.shared.base.IView
import com.azharkova.sampledi.shared.di.DIManager
import java.lang.ref.WeakReference
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class Interactors<T:Any>(private val clazz: KClass<T>, private val view: IView, private val container: DIManager = App.container):
    ReadWriteProperty<Any?, T?> {
    private var wref : WeakReference<T>? = null

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        wref = value?.let { WeakReference(it) }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        if (wref == null) {
            wref = WeakReference(container.resolve(view) as? T)
        }
        return wref?.get()
    }
}

//simply weakify
public inline fun <reified T:Any> interactors(view: IView) = Interactors(T::class, view)