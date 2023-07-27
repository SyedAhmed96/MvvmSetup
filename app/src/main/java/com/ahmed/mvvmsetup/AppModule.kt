package com.ahmed.mvvmsetup

import com.ahmed.mvvmsetup.core.RetroService
import com.ahmed.mvvmsetup.presentation.login.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideLoginRepository() = LoginRepository(provideRetroService())

    @Provides
    fun provideRetroService() = RetroService.getInstance()
}