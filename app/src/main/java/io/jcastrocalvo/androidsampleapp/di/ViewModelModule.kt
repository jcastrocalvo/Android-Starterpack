package io.jcastrocalvo.androidsampleapp.di

import dagger.Module
import dagger.Provides
import io.jcastrocalvo.androidsampleapp.viewModels.MainActivityViewModel
import io.jcastrocalvo.core.scopes.ActivityScope


@Module
class ViewModelModule {
    @ActivityScope
    @Provides
    fun provideMainActivityViewModel(): MainActivityViewModel = MainActivityViewModel()
}