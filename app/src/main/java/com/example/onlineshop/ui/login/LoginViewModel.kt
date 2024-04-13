package com.example.onlineshop.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.repository.LoginRepository

class LoginViewModel:ViewModel() {


    private val repository=LoginRepository()
    private var _isLogin=MutableLiveData<Pair<Boolean,String>>()
    val isLogin:LiveData<Pair<Boolean, String>>
    get() = _isLogin

    init {
        _isLogin=repository.isLogin
    }
    fun loginWithEmailAndPassword(
        email:String,
        password:String
    ){
     repository.loginWithEmailAndPassword(email, password)
    }
}