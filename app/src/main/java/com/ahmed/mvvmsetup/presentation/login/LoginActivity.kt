package com.ahmed.mvvmsetup.presentation.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.ahmed.mvvmsetup.R
import com.ahmed.mvvmsetup.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        viewModel.movieList.observe(this) {
            for (i in 0 until it.size) {
                Log.d("movies",""+it.get(i).name)
            }
        }
    }
}