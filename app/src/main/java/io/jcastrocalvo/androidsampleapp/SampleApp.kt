package io.jcastrocalvo.androidsampleapp

import android.app.Application
import android.content.Context
import io.jcastrocalvo.core.ContextModule
import io.jcastrocalvo.core.CoreComponent
import io.jcastrocalvo.core.CoreComponentProvider
import io.jcastrocalvo.core.DaggerCoreComponent
import io.jcastrocalvo.core.utils.ThemeUtils
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

class SampleApp : Application(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent
    @Inject
    lateinit var themeUtils: ThemeUtils

    /**
     * The onCreate of the whole application
     * Needs to create and get hte CoreComponent
     */
    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

        initializeTimber()
        randomNightMode()
    }

    /**
     * initializes the logging library Timber
     */
    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * randomizes dark mode so you can see both sides if possible
     */
    private fun randomNightMode() {
        if (BuildConfig.DEBUG) {
            themeUtils.setNightMode(Random.nextBoolean(), 0)
        }
    }

    /**
     * provides the core component for sub modules
     */
    override fun provideCoreComponent(): CoreComponent = coreComponent

    companion object {
        /**
         * Obtain core dagger component.
         *
         * @param context The application context
         */
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? SampleApp)?.coreComponent
    }
}