package com.example.mercadozona2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ConfirmarCompraActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_compra)

        //volver atras/cancelar
        findViewById<Button>(R.id.cancelarbtn).setOnClickListener { finish() }

        //continuar
        findViewById<Button>(R.id.continuarbtn).setOnClickListener { startActivity(Intent(this, FacturaActivity::class.java)) }
        findViewById<Button>(R.id.continuarbtn2).setOnClickListener { startActivity(Intent(this, FacturaActivity::class.java)) }

        //metodo seleccionado
        val metodoDePagoTV = findViewById<TextView>(R.id.metodoDePagoTV)
        metodoDePagoTV.text
        var metodo = String()
        if(intent.hasExtra("Mercado Pago")){
            metodo = intent.getStringExtra("Mercado Pago").toString()
            metodoDePagoTV.text = metodo
        } else if (intent.hasExtra("Rapi Pago")){
            metodo = intent.getStringExtra("Rapi Pago").toString()
            metodoDePagoTV.text = metodo
        } else if (intent.hasExtra("Tarjeta")) {
            metodo = intent.getStringExtra("Tarjeta").toString()
            metodoDePagoTV.text = metodo
        }

        val imagen = findViewById<ImageView>(R.id.imagen_info)
        Glide.with(this).load(intent.getStringExtra("Imagen")).into(imagen)

        val descripcion = findViewById<TextView>(R.id.descripcion_main)
        val descripcionIntent = intent.getStringExtra("Descripcion").toString()
        descripcion.text = descripcionIntent

        val precioEnvio = findViewById<TextView>(R.id.precioEnvio_ConfirmarActivity)
        val precioEnvioIntent = intent.getStringExtra("Envio").toString()
        precioEnvio.text = precioEnvioIntent
        //precioEnvio.text = findViewById<TextView>(R.id.precioEnvio_prod).text.toString()

        val precioProducto = findViewById<TextView>(R.id.precioProducto_ConfirmarActivity)
        val precioProductoIntent = intent.getStringExtra("Precio").toString()
        precioProducto.text = precioProductoIntent

        val precioTotal = findViewById<TextView>(R.id.precioTotal_ConfirmarActivity)
        precioTotal.text = precioProductoIntent

        val precioTotal2 = findViewById<TextView>(R.id.precioTotal_ConfirmarActivity2)
        precioTotal2.text = precioProductoIntent

        //obtener datos prefs
        val prefs:SharedPreferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)

        val direccion = findViewById<TextView>(R.id.direccionConfirmar)
        direccion.text = prefs.getString("calle", "") + " " + prefs.getString("altura", "")

        val nombre = findViewById<TextView>(R.id.nombre_confirmar)
        nombre.text = prefs.getString("nombre", "")

        val dni = findViewById<TextView>(R.id.dni_comprarActivity)
        dni.text = prefs.getString("dni","")

        val fecha = findViewById<TextView>(R.id.fechaDeseada)
        fecha.text = prefs.getString("fecha", "")

        val hora = findViewById<TextView>(R.id.horaDeseada)
        hora.text = prefs.getString("hora", "")

        /*val tarj = findViewById<TextView>(R.id.numTarjeta)
        tarj.text = prefs.getString("tarjeta", "")*/
    }
}