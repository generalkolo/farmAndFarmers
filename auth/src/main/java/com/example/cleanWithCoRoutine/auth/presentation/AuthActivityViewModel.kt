package com.example.cleanWithCoRoutine.auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanWithCoRoutine.auth.utils.AuthState
import com.example.cleanWithCoRoutine.common.utils.Event
import com.example.cleanWithCoRoutine.domain.models.auth.User
import com.example.cleanWithCoRoutine.domain.usecases.auth.GetDefaultUserLoginUsecase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthActivityViewModel @Inject constructor(
    private val getDefaultUserLoginUsecase: GetDefaultUserLoginUsecase
) : ViewModel() {

    private lateinit var user: User

    init {
        viewModelScope.launch {
            getDefaultUserLoginUsecase.invoke().collect { defaultUser ->
                user = defaultUser
            }
        }
    }

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
            if (email != user.email) {
                _authenticationError.postValue(Event(AuthState.emailError("Wrong Email credentials entered")))
                return
            }
        }
        if (password.isEmpty()) {
            _authenticationError.postValue(Event(AuthState.passwordError("Password cannot be empty")))
            return
        } else {
            if (password != user.password) {
                _authenticationError.postValue(Event(AuthState.passwordError("Wrong Password entered")))
                return
            }
        }
        if (email == user.email && password == user.password) {
            _userAuthenticated.postValue(Event(true))
        }
    }
}