package br.com.kimalextst.pokecodetraining.core

import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

fun AppCompatImageView.loadImage(url: String) {
    Picasso.get().load(url)
        .into(this)
}