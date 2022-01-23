package com.example.mercadozona2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ComprarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar)

        //volver atras/cancelar
        findViewById<Button>(R.id.cancelarbtn).setOnClickListener { finish() }

        //continuar
        val envio = findViewById<TextView>(R.id.precioEnvio_prod)
        val precioIntent = intent.getStringExtra("Envio").toString()
        envio.text = precioIntent

        val descrpcionIntent = intent.getStringExtra("Descripcion").toString()
        val descripcionProd = findViewById<TextView>(R.id.descripcion_main)
        descripcionProd.text = descrpcionIntent

        val url = findViewById<TextView>(R.id.urlprod)
        url.text = intent.getStringExtra("Imagen").toString()

        val nombre = findViewById<EditText>(R.id.nombreEt_comprarActivity)
        val dni = findViewById<EditText>(R.id.dni_comprarActivity)
        val calle = findViewById<EditText>(R.id.nombreCalle_comprarActivity)
        val altura = findViewById<EditText>(R.id.alturaCalle_comprarActivity)
        val fecha = findViewById<EditText>(R.id.fechaDeseada)
        val hora = findViewById<EditText>(R.id.horaDeseada)

        //continuar
        findViewById<Button>(R.id.continuarbtn).setOnClickListener {
            //guardado posible edicion/cambio de datos
            val prefs: SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.putString ("nombre", nombre.text.toString() ?: "")
            prefs.putString("calle", calle.text.toString() ?: "")
            prefs.putString("altura", altura.text.toString() ?: "")
            prefs.putString("dni", dni.text.toString())
            prefs.putString("fecha", fecha.text.toString())
            prefs.putString("hora", hora.text.toString())
            prefs.apply()

            if (nombre.text.isEmpty() || dni.text.isEmpty() || calle.text.isEmpty() ||
                altura.text.isEmpty() || fecha.text.isEmpty() || hora.text.isEmpty()){
                Toast.makeText(this, "Debes completar todos los campos para poder continuar", Toast.LENGTH_SHORT).show()
            } else {
            startActivity(Intent(this, MetodosDePagoActivity::class.java)
                .putExtra("Envio", envio.text.toString())
                .putExtra("Precio", findViewById<TextView>(R.id.precio_comprar).text.toString())
                .putExtra("Descripcion", descripcionProd.text.toString())
                .putExtra("Imagen", url.text.toString())
            ) }
            }

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)

        //precio
        val precio = findViewById<TextView>(R.id.precio_comprar)
        precio.text = intent.getStringExtra("Precio").toString()

        nombre.setText(prefs.getString("nombre", ""))
        calle.setText(prefs.getString("calle", ""))
        altura.setText(prefs.getString("altura", ""))
        dni.setText(prefs.getString("dni",""))


        /*val nombre = findViewById<EditText>(R.id.nombreEt)
        val nombreCompraActivity = findViewById<EditText>(R.id.nombreEt_comprarActivity)
        nombreCompraActivity.text = nombre.text*/

        //funcion para fecha
        showDatePickerDialog()

        //funcion para hora
        showTimePickerDialog()
    }
    //funcion para fecha
    fun showDatePickerDialog(){
        findViewById<EditText>(R.id.fechaDeseada).setOnClickListener{
            val datePicker =  DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
            datePicker.show(supportFragmentManager, "date picker")
        }
    }

    //funcion para fecha
    fun onDateSelected(day:Int, month: Int, year:Int){
        findViewById<EditText>(R.id.fechaDeseada).setText("$day/$month/$year")
    }

    //funcion para hora
    fun showTimePickerDialog(){
        findViewById<EditText>(R.id.horaDeseada).setOnClickListener {
            val timePicker = TimePickerFragment{onTimeSelected(it)}
            timePicker.show(supportFragmentManager, "time")
        }
    }

    //funcion para hora
    fun onTimeSelected(time:String){
        findViewById<EditText>(R.id.horaDeseada).setText("$time")
    }
}