package com.example.mercadozona2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_carrito.*

class CarritoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        //lanzador perfil activity
        findViewById<ImageButton>(R.id.perfilbtn).setOnClickListener{ startActivity(Intent(this, PerfilActivity::class.java)) }

        val img = findViewById<ImageView>(R.id.imagen_Art1)
        Glide.with(this)
            .load(intent.getStringExtra("Imagen"))
            .error(R.mipmap.ic_launcher_round)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(img)

        //eliminar button
        val x1 = findViewById<Button>(R.id.botonX_carrito1)
        val x2 = findViewById<Button>(R.id.botonX_carrito2)
        val x3 = findViewById<Button>(R.id.botonX_carrito3)
        val x4 = findViewById<Button>(R.id.botonX_carrito4)
        val x5 = findViewById<Button>(R.id.botonX_carrito5)
        val guardarCambiosBtn = findViewById<Button>(R.id.guardarCambiosbtn)
        val eliminarCarritobtn =findViewById<Button>(R.id.eliminarCarritobtn)

        //llenar carrito
        val art1 = findViewById<LinearLayout>(R.id.Art1_cont)
        val art2 = findViewById<LinearLayout>(R.id.Art2_cont)
        val art3 = findViewById<LinearLayout>(R.id.Art3_cont)
        val art4 = findViewById<LinearLayout>(R.id.Art4_cont)
        val art5 = findViewById<LinearLayout>(R.id.Art5_cont)

        art1.visibility = View.GONE
        art2.visibility = View.GONE
        art3.visibility = View.GONE
        art4.visibility = View.GONE
        art5.visibility = View.GONE

        //intento de guardar arts de carrito en prefs
        val prefs:SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
        val prefsOk = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)

        prefs.putString("Art0", "Art0")

        if (intent.hasExtra("NuevoArt") && prefsOk.contains("Art0")){
            art1.visibility = View.VISIBLE
            ArtDescripcion1.text = intent.getStringExtra("Descripcion")
            ArtPrecio1.text = intent.getStringExtra("Precio")
            prefs.putString("uno", "uno")
            //savedInstanceState
        }
        if (prefsOk.contains("uno")){
            art1.visibility = View.VISIBLE
        }
        if (intent.hasExtra("NuevoArt") && prefsOk.contains("Art1")){
            art2.visibility = View.VISIBLE
            ArtDescripcion2.text = intent.getStringExtra("Descripcion")
            ArtPrecio2.text = intent.getStringExtra("Precio")
            intent.putExtra("dos", true)
        }

        //agregar button
        findViewById<Button>(R.id.agregarCarritobtn).setOnClickListener {
            //intento de guardar arts de carrito en prefs
            if (prefsOk.contains("uno") == true) {
                prefs.putString("Art1", ArtDescripcion2.text.toString())
                prefs.putString("Precio1", ArtPrecio1.text.toString()) }
            if (intent.getBooleanExtra("dos", true)) { prefs.putString("Art2","Art2") }

            startActivity(Intent(this, MainActivity::class.java).putExtra("AppAbierta", true))
        }


        /*when {
            prefsOk.contains("Art1") -> {
                art1.visibility = View.VISIBLE
                ArtDescripcion1.text = intent.getStringExtra("Descripcion")
                ArtPrecio1.text = prefsOk.getString("PrecioArt1", "")
            }
            prefsOk.contains("Art2") -> {
                art2.visibility = View.VISIBLE
                ArtDescripcion1.text = prefsOk.getString("Art2", "").toString()
                ArtPrecio1.text = prefsOk.getString("PrecioArt2", "").toString()
            }
            prefsOk.contains("Art3") -> {
                art3.visibility = View.VISIBLE
                ArtDescripcion1.text = prefsOk.getString("Art3", "").toString()
                ArtPrecio1.text = prefsOk.getString("PrecioArt3", "").toString()
            }
            prefsOk.contains("Art4") -> {
                art4.visibility = View.VISIBLE
                ArtDescripcion1.text = prefsOk.getString("Art4", "").toString()
                ArtPrecio1.text = prefsOk.getString("PrecioArt4", "").toString()
            }
            prefsOk.contains("Art5") -> {
                art5.visibility = View.VISIBLE
                ArtDescripcion1.text = prefsOk.getString("Art5", "").toString()
                ArtPrecio1.text = prefsOk.getString("PrecioArt5", "").toString()
            }
        }*/


        eliminarCarritobtn.setOnClickListener {
            x1.visibility = View.VISIBLE
            x2.visibility = View.VISIBLE
            x3.visibility = View.VISIBLE
            x4.visibility = View.VISIBLE
            x5.visibility = View.VISIBLE
            guardarCambiosBtn.visibility = View.VISIBLE
            eliminarCarritobtn.visibility = View.GONE
        }

        guardarCambiosBtn.setOnClickListener {
            x1.visibility = View.GONE
            x2.visibility = View.GONE
            x3.visibility = View.GONE
            x4.visibility = View.GONE
            x5.visibility = View.GONE
            guardarCambiosBtn.visibility = View.GONE
            eliminarCarritobtn.visibility = View.VISIBLE
        }

        x1.setOnClickListener {
            art1.visibility = View.GONE
        }

        x2.setOnClickListener {
            art2.visibility = View.GONE
        }

        x3.setOnClickListener {
            art3.visibility = View.GONE
        }

        x4.setOnClickListener {
            art4.visibility = View.GONE
        }

        x5.setOnClickListener {
            art5.visibility = View.GONE
        }
        comprarCarrito()
    }

    fun comprarCarrito(){
        comprarcarritobtn.setOnClickListener {
            Toast.makeText(this, "Funcion disponible proximamente!", Toast.LENGTH_SHORT).show()
        }
    }
}