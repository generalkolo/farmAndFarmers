package com.example.cleanWithCoRoutine.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanWithCoRoutine.auth.utils.AuthState
import com.example.cleanWithCoRoutine.auth.utils.Event
import com.example.cleanWithCoRoutine.auth.utils.matchingEmail
import com.example.cleanWithCoRoutine.auth.utils.matchingPassword

class AuthActivityViewModel : ViewModel() {
    private val _authenticationError = MutableLiveData<Event<AuthState>>()
    val authenticationError: LiveData<Event<AuthState>>
        get() = _authenticationError

    private val _userAuthenticated = MutableLiveData<Event<Boolean>>()
    val userAuthenticated: LiveData<Event<Boolean>>
        get() = _userAuthenticated

    fun validateEmailAndPassword(email: String, password: String) {
        if (email.isEmpty()) {
            _authenticationError.postValue(Event(AuthState.emailError("Email cannot be empty")))
            return
        } else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _authenticationError.postValue(Event(AuthState.emailError("Email is not a valid email address")))
                return
            }
            if (email != matchingEmail) {
                _authenticationError.postValue(Event(AuthState.emailError("Wrong Email credentials entered")))
                return
            }
        }
        if (password.isEmpty()) {
            _authenticationError.postValue(Event(AuthState.passwordError("Password cannot be empty")))
            return
        } else {
            if (password != matchingPassword.toString()) {
                _authenticationError.postValue(Event(AuthState.passwordError("Wrong Password cannot be empty")))
                return
            }
        }
        if (email == matchingEmail && password == matchingPassword.toString()) {
            _userAuthenticated.postValue(Event(true))
        }
    }
}