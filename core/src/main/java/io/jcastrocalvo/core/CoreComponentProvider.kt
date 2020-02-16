package io.jcastrocalvo.core

/**
 * The core module needs an application context as DI root. Therefor, the application classes of the apps using this module
 * should implement [CoreComponentProvider].
 */
interface CoreComponentProvider {
    /**
     * Returns the CoreComponent / DI root
     */
    fun provideCoreComponent(): CoreComponent
}