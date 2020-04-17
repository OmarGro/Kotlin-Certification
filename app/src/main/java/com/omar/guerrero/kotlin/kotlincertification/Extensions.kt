package com.omar.guerrero.kotlin.kotlincertification

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun Context.toast(message : String, length : Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message , length).show()
}

inline fun <reified T : View> ViewGroup.inflate(idRes : Int) : T {
    return LayoutInflater.from(context).inflate(idRes, this, false) as T
}

inline fun <reified T: Activity> Context.startActivity(){
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : View> View.find(idRes: Int): T{
    return this.findViewById(idRes)
}