package com.example.cleanWithCoRoutine.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanWithCoRoutine.auth.utils.AUTH_ERRORS
import com.example.cleanWithCoRoutine.auth.utils.Event

class AuthActivityViewModel : ViewModel() {
    private val _authenticationError = MutableLiveData<Event<AUTH_ERRORS>>()
    val authenticationError: LiveData<Event<AUTH_ERRORS>>
        get() = _authenticationError

    private val _userAuthenticated = MutableLiveData<Event<Boolean>>()
    val userAuthenticated: LiveData<Event<Boolean>>
        get() = _userAuthenticated

    fun validateEmailAndPassword(email: String, password: String) {
        if (email.isEmpty()) {
            _authenticationError.postValue(Event(AUTH_ERRORS.EMAIL_ERROR))
            return
        } else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                _authenticationError.postValue(Event(AUTH_ERRORS.EMAIL_ERROR))
                return
            }
            if (email != "matchingEmail") {
                _authenticationError.postValue(Event(AUTH_ERRORS.EMAIL_ERROR))
                return
            }
        }
        if (password.isEmpty()) {
            _authenticationError.postValue(Event(AUTH_ERRORS.PASSWORD_ERROR))
            return
        } else {
            if (password != "MatchingPasword") {
                _authenticationError.postValue(Event(AUTH_ERRORS.PASSWORD_ERROR))
                return
            }
        }
        if (email == "MatchingEmail" && password == "MatchingPassword") {
            _userAuthenticated.postValue(Event(true))
        }
    }
}