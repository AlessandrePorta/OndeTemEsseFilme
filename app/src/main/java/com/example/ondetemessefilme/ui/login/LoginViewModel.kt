package com.example.ondetemessefilme.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.ondetemessefilme.utils.validateEmail
import com.example.ondetemessefilme.utils.validatePassword

class LoginViewModel : ViewModel() {

    private val _login = MutableLiveData<LoginVO>()
    val login : LiveData<LoginResponseVO> = _login.switchMap { loginVO -> MutableLiveData(validateEmail(loginVO.email!!, loginVO.senha!!)) }

    private fun validateEmail(email: String, password: String) : LoginResponseVO {
        return when {
            !email.validateEmail() -> LoginResponseVO(false, "Digite um email válido!")
            !password.validatePassword() -> LoginResponseVO(false, "Digite uma senha válida")
            else -> {
                LoginResponseVO(true)
            }
        }
    }

    fun doLogin(loginVO : LoginVO){
        _login.postValue(loginVO)
    }
}

