package io.jcastrocalvo.androidsampleapp.di

import dagger.Component
import io.jcastrocalvo.androidsampleapp.MainActivity
import io.jcastrocalvo.core.CoreComponent
import io.jcastrocalvo.core.scopes.ActivityScope
import javax.inject.Singleton

@ActivityScope
@Component(modules = [ViewModelModule::class],
        dependencies = [
    CoreComponent::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}