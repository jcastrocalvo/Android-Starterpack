package io.jcastrocalvo.androidsampleapp

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import io.jcastrocalvo.core.CoreComponent
import io.jcastrocalvo.core.CoreComponentProvider
import io.jcastrocalvo.core.DaggerCoreComponent
import io.jcastrocalvo.core.modules.ContextModule
import timber.log.Timber
import kotlin.random.Random

class AndroidSampleApp : Application(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

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
        initializeTheme()
    }

    /**
     * initializes the logging library Timber
     */
    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initializeTheme() {
        if (BuildConfig.DEBUG) {
            AppCompatDelegate.setDefaultNightMode(
                if (Random.nextBoolean()) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
            )
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
            (context.applicationContext as? AndroidSampleApp)?.coreComponent
    }
}