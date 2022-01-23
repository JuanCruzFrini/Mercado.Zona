package com.example.mercadozona2

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegistroCompletadoActivity : AppCompatActivity() {
    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_completado)

        val email = findViewById<TextView>(R.id.email_registro)
        val emailIntent = intent.getStringExtra("Email").toString()
        email.text = emailIntent

        val contra = findViewById<TextView>(R.id.contra_registro)
        val contraIntent = intent.getStringExtra("Contra").toString()
        contra.text = contraIntent

        //cerrar sesion sign out
        findViewById<Button>(R.id.cerrarSesionbtn).setOnClickListener {
            val prefs:SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()//borramos las prefs guardadas
            prefs.apply()//aseguramos que se ejecuto la delete
            FirebaseAuth.getInstance().signOut()
            onBackPressed() // volver a la pantalla anterior
        }

        //guardado de datos
        val prefs:SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString ("email", email.text.toString())
        prefs.putString("contraseña", contra.text.toString())
        prefs.apply()
    }
}