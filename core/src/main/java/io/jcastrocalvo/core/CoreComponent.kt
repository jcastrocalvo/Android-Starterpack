package io.jcastrocalvo.core

import android.content.Context
import dagger.Component
import io.jcastrocalvo.core.modules.ContextModule
import io.jcastrocalvo.core.modules.CoreModule
import javax.inject.Singleton

/**
 * Core component that all module's components depend on.
 */
@Singleton
@Component(modules = [
    CoreModule::class,
    ContextModule::class])
interface CoreComponent {

    /*
    This method allows us to expose parent objects to dependent components
     */

    fun context(): Context
}