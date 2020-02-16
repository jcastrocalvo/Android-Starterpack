package io.jcastrocalvo.androidsampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.jcastrocalvo.androidsampleapp.AndroidSampleApp.Companion.coreComponent
import io.jcastrocalvo.androidsampleapp.di.DaggerMainActivityComponent
import io.jcastrocalvo.core.CoreComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainActivityComponent
            .builder()
            .coreComponent(coreComponent(this))
            .build()
            .inject(this)
    }
}
