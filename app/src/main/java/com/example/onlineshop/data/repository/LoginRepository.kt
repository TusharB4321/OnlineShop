package com.example.onlineshop.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.onlineshop.data.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class LoginRepository {

    private val auth=FirebaseAuth.getInstance()
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    val isLogin=MutableLiveData<Pair<Boolean,String>>()
    val isRegister=MutableLiveData<Pair<Boolean,String>>()
    private val isCurrentUserExist=MutableLiveData<Boolean>()


    private fun getFirebaseUserUid():String=auth.currentUser?.uid.orEmpty()
   fun loginWithEmailAndPassword(
       email:String,
       password:String
   ){
       auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
           isLogin.value=Pair(true,"Login User Successfully")
       }.addOnFailureListener {
           isLogin.value=Pair(false,it.message.orEmpty())
       }
   }
    fun  registerWithEmailAndPassword(
        user: User,
        password: String,
    ) {
        auth.createUserWithEmailAndPassword(user.email, password).addOnSuccessListener {
            val userModel = hashMapOf(
                "id" to getFirebaseUserUid(),
                "email" to user.email,
                "nickname" to user.nickname,
                "phone_number" to user.phoneNumber
            )

            firebaseFirestore.collection("users").document(getFirebaseUserUid()).set(userModel)
                .addOnSuccessListener {
                    isRegister.value = Pair(true, "Registration successful")
                }.addOnFailureListener {
                    isRegister.value = Pair(false, it.message.orEmpty())
                }
        }.addOnFailureListener {
            isRegister.value = Pair(false, it.message.orEmpty())
        }
    }

    fun checkCurrentUser(){
        isCurrentUserExist.value=auth.currentUser!=null
    }

    fun signOut()=auth.signOut()
}