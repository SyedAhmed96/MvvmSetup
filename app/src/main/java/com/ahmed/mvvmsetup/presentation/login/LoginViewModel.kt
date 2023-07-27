package com.ahmed.mvvmsetup.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmed.mvvmsetup.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel
@Inject
constructor(private val loginRepository: LoginRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val movieList = MutableLiveData<List<Movie>>()
    var job: Job? = null

    val exceptionHandler = CoroutineExceptionHandler{_, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }

    var loading = MutableLiveData<Boolean>(false)

    fun getAllMovies() {
        loading.value = true

        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {

            val response = loginRepository.getAllMovies()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful){
                    movieList.postValue(response.body())
                    loading.value = false
                } else{
                    onError("Error : ${response.message()}")
                }
            }
        }
    }

    private fun onError (message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}