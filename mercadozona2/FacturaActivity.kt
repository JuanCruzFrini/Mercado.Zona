package com.example.mercadozona2

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FacturaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        //animaciones
        val felicidades = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.felicidades)
        val acreditacion = AnimationUtils.loadAnimation(this, R.anim.acreditacion)
        val continuar = AnimationUtils.loadAnimation(this, R.anim.continuar)

        findViewById<TextView>(R.id.acreditacionText).startAnimation(acreditacion)
        findViewById<TextView>(R.id.felicidadesText).startAnimation(felicidades)
        findViewById<TextView>(R.id.continuarText).startAnimation(continuar)
        findViewById<TextView>(R.id.continuarbtn).startAnimation(continuar)


        //lanzador perfil activity
        findViewById<ImageButton>(R.id.perfilbtn).setOnClickListener{ startActivity(Intent(this, PerfilActivity::class.java)) }

        //lanzador carrito
        findViewById<ImageButton>(R.id.carritoNav).setOnClickListener{ startActivity(Intent(this, CarritoActivity::class.java))}

        //volver inicio
        findViewById<Button>(R.id.continuarbtn).setOnClickListener { startActivity(Intent(this, MainActivity::class.java).putExtra("AppAbierta", true)) }
    }
}