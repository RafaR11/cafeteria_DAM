package com.example.cafeteria_final.Shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private var _loggedUser = MutableLiveData("")
    var plat1 = String()
    var plat2 = String()
    var plat3 = String()
    var preu= String()


    fun getplat1(): String {return ""+plat1}
    fun getplat2(): String {return ""+plat2}
    fun getplat3(): String {return ""+plat3}
    fun getpreu(): String {return ""+preu}

    fun setplat1(text: String){
        plat1=text
    }
    fun setplat2(text: String){
        plat2=text
    }
    fun setplat3(text: String){
        plat3=text
    }
    fun setpreu(text: String){
        preu=text
    }

}