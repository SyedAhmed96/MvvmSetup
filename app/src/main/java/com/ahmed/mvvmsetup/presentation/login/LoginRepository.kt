package com.ahmed.mvvmsetup.presentation.login

import com.ahmed.mvvmsetup.core.RetroService
import javax.inject.Inject

class LoginRepository
@Inject
constructor(private val retroService: RetroService) {
    suspend fun getAllMovies() = retroService.getAllMovies()
}