package com.example.onlineshop.ui.login

import android.content.Intent
import android.os.Binder
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private val viewModel:LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()

        with(binding){

            btnLogin.setOnClickListener{
                clearErrors()
                val email=etEmail.toString()
                val password=etPassword.toString()
                when{
                    email.isEmpty()->tilEmail.error="Email cant be empty"
                    email.isNotEmpty()&&password.isEmpty()->tilPassword.error="password cant be empty"
                    else->viewModel.loginWithEmailAndPassword(email,password)
                }
            }

            btnRegister.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }

        }

    }

    private fun initObserver() {
        viewModel.isLogin.observe(viewLifecycleOwner){
            if (it.first){
                Toast.makeText(requireContext(), it.second, Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
            }else{
                Toast.makeText(requireContext(), it.second, Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun clearErrors() = with(binding){
        tilEmail.isErrorEnabled
        tilPassword.isErrorEnabled
    }

}