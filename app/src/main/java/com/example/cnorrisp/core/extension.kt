package com.example.cnorrisp.core

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun String.happy():String {
    return "$this + ;)"
}

// get color
fun Activity.color(@ColorRes color:Int)= ContextCompat.getColor(this,color)

// check int nullability
fun Any?.isNull() = this == null

//Toast
fun Activity.toast(text:String, length:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,text,length).show()
}

//fun ImageView.load(url:String){
//    if(url.isNotEmpty()){
//        Glide.with(this.context).load(url).into(this)
//    }
//}

//Picasso
//fun ImageView.load(url:String) {
//    if (url.isNotEmpty()) {
//        Picasso.get().load(url).into(this)
//    }
//}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
