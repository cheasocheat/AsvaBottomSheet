package com.asvacode.asvalibrary.extension

import android.net.Uri
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by cheasocheat on 3/14/18.
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).into(this)
}

fun ImageView.loadLocal(url: Int) {
    Glide.with(context).load(url).into(this)
}

fun ImageView.loadUri(uri: Uri){
    Glide.with(context).load(uri).into(this)
}