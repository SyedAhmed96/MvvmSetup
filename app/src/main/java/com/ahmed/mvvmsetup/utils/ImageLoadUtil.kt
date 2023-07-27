package com.ahmed.mvvmsetup.utils

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Environment
import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import java.io.File
import java.io.FileOutputStream
import java.util.*


object ImageLoadUtil {
    fun loadImageWithoutPlaceHolder(url: String, imageView: ImageView?) {
        if (MyUtils.isNullOrEmpty(url)) return
        Picasso.get()
            .load(url)
            .fit()
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    Log.e("ImageUtils", "onSuccess: url $url")
                }

                override fun onError(e: Exception) {
                    Log.e("ImageUtils", "onError:  url \n$url Exception$e")
                }
            })
    }

    fun loadImage(url: String, imageView: ImageView?, placeHolder: Int) {
        if (MyUtils.isNullOrEmpty(url)) return
        Picasso.get()
            .load(url)
            .fit()
            .placeholder(placeHolder)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    Log.e("ImageUtils", "onSuccess: url $url")
                }

                override fun onError(e: Exception) {
                    Log.e("ImageUtils", "onError:  url \n$url Exception$e")
                }
            })
    }

    // .placeholder(placeHolder)
    @kotlin.jvm.JvmStatic
    fun loadImageNotFit(url: String, imageView: ImageView?, placeHolder: Int) {
        if (MyUtils.isNullOrEmpty(url)) return
        Picasso.get()
            .load(url)
            .placeholder(placeHolder)
            .into(imageView, object : Callback {
                override fun onSuccess() {
                    Log.e("ImageUtils", "onSuccess: url $url")
                }

                override fun onError(e: Exception) {
                    Log.e("ImageUtils", "onError:  url \n$url Exception$e")
                }
            })
    }

    fun loadImageWithCache(url: String?, imageView: ImageView?, placeHolder: Int) {
        Picasso.get()
            .load(url)
            .fit()
            .placeholder(placeHolder)
            .into(imageView)
    }

}