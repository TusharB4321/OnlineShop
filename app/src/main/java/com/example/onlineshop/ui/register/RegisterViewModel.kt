package com.example.onlineshop.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshop.data.model.User
import com.example.onlineshop.data.repository.LoginRepository

class RegisterViewModel:ViewModel() {

    private val repository=LoginRepository()
    private var _isRegister=MutableLiveData<Pair<Boolean,String>>()
    val isRegister:LiveData<Pair<Boolean,String>>
    get() = _isRegister

    init {
        _isRegister=repository.isRegister
    }

    fun register(
        user:User,
        password:String
    ){
        repository.registerWithEmailAndPassword(user,password)
    }
}