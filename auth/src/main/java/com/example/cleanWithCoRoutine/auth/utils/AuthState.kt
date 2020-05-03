package com.example.cleanWithCoRoutine.auth.utils

class AuthState constructor(
    val state: AUTH_ERRORS,
    val message: String? = null
) {
    companion object {
        @JvmStatic
        fun emailError(
            message: String? = null
        ): AuthState = AuthState(
            state = AUTH_ERRORS.EMAIL_ERROR,
            message = message
        )

        @JvmStatic
        fun passwordError(
            message: String? = null
        ): AuthState = AuthState(
            state = AUTH_ERRORS.PASSWORD_ERROR,
            message = message
        )
    }
}