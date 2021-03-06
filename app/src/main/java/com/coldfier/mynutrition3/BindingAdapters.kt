package com.coldfier.mynutrition3

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions().error(R.mipmap.no_image_icon))
            .into(imgView)
    }
}

@BindingAdapter("setCalories")
fun bindCalories(textView: TextView, text: String?) {
    text?.let {
        val correctValue = text.substring(0, (text.indexOf(".") + 2))
        textView.text = correctValue
    }
}