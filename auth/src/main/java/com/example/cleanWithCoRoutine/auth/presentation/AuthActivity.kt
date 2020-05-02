package com.example.cleanWithCoRoutine.auth.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.cleanWithCoRoutine.auth.R

class AuthActivity : AppCompatActivity() {
    private lateinit var authActivityViewModel: AuthActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authActivityViewModel =
            ViewModelProvider(this).get(AuthActivityViewModel::class.java)
        setContentView(R.layout.activity_auth)
    }
}