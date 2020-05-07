package com.example.cleanWithCoRoutine.auth.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.auth.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var authActivityViewModel: AuthActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authActivityViewModel =
            ViewModelProvider(this, viewModelFactory).get(AuthActivityViewModel::class.java)
        setContentView(R.layout.activity_auth)
    }
}