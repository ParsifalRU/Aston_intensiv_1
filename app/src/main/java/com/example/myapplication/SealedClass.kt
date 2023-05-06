package com.example.myapplication

import android.util.Log
import com.example.myapplication.SealedClass.ExampleSealedClass

sealed class SealedClass(val value: String){
    class ExampleSealedClass: SealedClass("Привет из Силда")
}

class TestSealedClass(){
    fun Test(sealedClass: SealedClass){
        when(sealedClass){
            is ExampleSealedClass -> {
                Log.d("LOGTAG", "key ${sealedClass.value}")
            }
        }
    }
}