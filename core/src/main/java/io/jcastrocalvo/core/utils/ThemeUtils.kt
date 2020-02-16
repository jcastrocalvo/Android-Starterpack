package io.jcastrocalvo.core.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate

class ThemeUtils  {

    fun isDarkTheme(context: Context) = context.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES

    fun isLightTheme(context: Context) = !isDarkTheme(context)

    fun setNightMode(forceNight: Boolean, delay: Long) {
        Handler().postDelayed({
            AppCompatDelegate.setDefaultNightMode(
                if (forceNight) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }
            )
        }, delay)
    }
}