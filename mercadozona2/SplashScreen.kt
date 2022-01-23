package com.example.mercadozona2

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //anim logo
        val animLogo = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        animLogo.duration = 2000
        val logo = findViewById<ImageView>(R.id.logo_splash)
        logo.animation = animLogo

        //anim txt continuar
        val animContinuar = AnimationUtils.loadAnimation(this, R.anim.acreditacion)
        animContinuar.startOffset = 2000
        val continuartxt = findViewById<TextView>(R.id.continuar_splash)
        continuartxt.animation = animContinuar

        //volver a main activity / continuar
        splash.setOnClickListener { onBackPressed() }
    }
}