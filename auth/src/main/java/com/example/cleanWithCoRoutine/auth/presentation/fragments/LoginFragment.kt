package com.example.cleanWithCoRoutine.auth.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cleanWithCoRoutine.auth.databinding.FragmentLoginBinding
import com.example.cleanWithCoRoutine.auth.presentation.AuthActivityViewModel
import com.example.cleanWithCoRoutine.auth.utils.AUTH_ERRORS
import com.example.cleanWithCoRoutine.auth.utils.EventObserver
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val authActivityViewModel by activityViewModels<AuthActivityViewModel> {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        initOnClickListener()
        initObservers()
        return binding.root
    }

    private fun initObservers() {
        authActivityViewModel.userAuthenticated.observe(
            viewLifecycleOwner,
            EventObserver { validated ->
                Log.d("Tag", validated.toString())
                if (validated) {
                    disAbleViewErrors()
                    val action = LoginFragmentDirections.navigateToStatistics()
                    findNavController().navigate(action)
                }
            })
        authActivityViewModel.authenticationError.observe(viewLifecycleOwner,
            EventObserver { errorType ->
                when (errorType.state) {
                    AUTH_ERRORS.EMAIL_ERROR -> {
                        showEmailError(errorType.message)
                    }
                    AUTH_ERRORS.PASSWORD_ERROR -> {
                        showPasswordError(errorType.message)
                    }
                }
            })
    }

    //Method for disable TextInput errors if any was previously shown
    private fun disAbleViewErrors() {
        with(binding) {
            emailTextInputLayout.error = null
            passwordTextInputLayout.error = null
        }
    }

    //method to show TextInput errors for the
    // password input
    private fun showPasswordError(error: String?) {
        error?.let {
            binding.passwordTextInputLayout.error = it
        }
    }

    //method to show TextInput errors for the
    // email input
    private fun showEmailError(error: String?) {
        error?.let {
            binding.emailTextInputEditText.error = it
        }
    }

    private fun initOnClickListener() {
        with(binding) {
            siginButton.setOnClickListener {
                disAbleViewErrors()
                val email = emailTextInputEditText.text.toString()
                val password = passwordTextInputEditText.text.toString()
                authActivityViewModel.validateEmailAndPassword(email, password)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}