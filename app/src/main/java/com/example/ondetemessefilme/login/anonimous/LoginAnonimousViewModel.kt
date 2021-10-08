package com.example.ondetemessefilme.login.anonimous

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.ondetemessefilme.utils.validateName

class LoginAnonimousViewModel : ViewModel() {

    private val _anonimousLogin = MutableLiveData<AnonimousVO>()
    val anonimousLogin : LiveData<AnonimousResponseVO> = _anonimousLogin.switchMap { AnonimousVO -> MutableLiveData(loginWithAnonimousAccount(AnonimousVO.name!!))}

    fun loginWithAnonimousAccount(name: String) : AnonimousResponseVO {
        return when {
            name.validateName(name) -> AnonimousResponseVO(false, "Digite um nome")
            else -> {
                AnonimousResponseVO(true)
            }
        }
    }

    fun doAnonimousLogin(anonimousVO : AnonimousVO){
        _anonimousLogin.postValue(anonimousVO)
    }

}