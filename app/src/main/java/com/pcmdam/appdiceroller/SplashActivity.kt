package com.pcmdam.appdiceroller;

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pcmdam.appdiceroller.MainActivity
import com.pcmdam.appdiceroller.R
import android.app.Activity
import androidx.core.content.ContextCompat.startActivity


class SplashActivity : AppCompatActivity()  {

    private val SPLASH_TIME_OUT: Long = 2000 // Tiempo de duración de la pantalla de inicio en milisegundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java) // Inicia tu actividad principal
            startActivity(intent)
            finish() // Cierra la actividad de inicio
        }, SPLASH_TIME_OUT)
    }
}
