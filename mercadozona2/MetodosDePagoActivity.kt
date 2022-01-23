package com.example.mercadozona2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

@Suppress("NAME_SHADOWING")
class MetodosDePagoActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodos_de_pago)

        //volver atras/cancelar
        findViewById<Button>(R.id.cancelarbtn).setOnClickListener { finish() }

        //radio buttons casteo
        val rbmp = findViewById<RadioButton>(R.id.rbmp)
        val rbmpClicked = findViewById<RadioButton>(R.id.rbmpClicked)
        var rbmpSelected = false

        val rbrp = findViewById<RadioButton>(R.id.rbrp)
        val rbrpClicked = findViewById<RadioButton>(R.id.rbrpClicked)
        var rbrpSelected = false


        val rbtarj = findViewById<RadioButton>(R.id.rbtarj)
        val rbtarjClicked = findViewById<RadioButton>(R.id.rbtarjClicked)
        var rbtarjSelected = false
        val numTarjeta = findViewById<EditText>(R.id.numTarjeta)
        numTarjeta.isEnabled = false
        numTarjeta.visibility = View.GONE

        //onClick MP
        rbmp.setOnClickListener {
            rbmpClicked.visibility = View.VISIBLE
            rbmp.visibility = View.GONE
            rbrp.isEnabled = false
            rbtarj.isEnabled = false
            numTarjeta.isEnabled = false
            rbmpSelected = true
        }
        rbmpClicked.setOnClickListener {
            rbmpClicked.visibility = View.GONE
            rbmp.visibility = View.VISIBLE
            rbrp.isEnabled = true
            rbtarj.isEnabled = true
            numTarjeta.isEnabled = true
            rbmpSelected = false
        }

        //onClick RP
        rbrp.setOnClickListener {
            rbrp.visibility = View.GONE
            rbrpClicked.visibility = View.VISIBLE
            rbmp.isEnabled = false
            rbtarj.isEnabled = false
            numTarjeta.isEnabled = false
            rbrpSelected = true
        }
        rbrpClicked.setOnClickListener {
            rbrpClicked.visibility = View.GONE
            rbrp.visibility = View.VISIBLE
            rbmp.isEnabled = true
            rbtarj.isEnabled = true
            rbrpSelected = false
        }

        //onClick Tarjetas
        rbtarj.setOnClickListener {
            rbtarjClicked.visibility = View.VISIBLE
            rbtarj.visibility = View.GONE
            numTarjeta.visibility = View.VISIBLE
            numTarjeta.isEnabled = true
            rbmp.isEnabled = false
            rbrp.isEnabled = false
            rbtarjSelected = true
        }
        rbtarjClicked.setOnClickListener {
            rbtarjClicked.visibility = View.GONE
            rbtarj.visibility = View.VISIBLE
            numTarjeta.visibility = View.GONE
            numTarjeta.isEnabled = false
            rbmp.isEnabled = true
            rbrp.isEnabled = true
            rbtarjSelected = false
        }

        //obtener de prefs
        val prefs = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE)
        numTarjeta.setText(prefs.getString("tarjeta", ""))

        //continuar
        val envio = findViewById<TextView>(R.id.precioEnvio_prod)
        val precioIntent = intent.getStringExtra("Envio").toString()
        envio.text = precioIntent

        //precio
        val precio = findViewById<TextView>(R.id.precio_comprar)
        precio.text = intent.getStringExtra("Precio").toString()

        //descripcion
        val descrpcionIntent = intent.getStringExtra("Descripcion").toString()
        val descripcionProd = findViewById<TextView>(R.id.descripcion_main)
        descripcionProd.text = descrpcionIntent

        //url
        val url = findViewById<TextView>(R.id.urlprod)
        url.text = intent.getStringExtra("Imagen").toString()

        findViewById<Button>(R.id.continuarbtn).setOnClickListener {
            //posible edicion del num de la tarjeta
           /* val prefs:SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
            prefs.putString("tarjeta", numTarjeta.text.toString())*/

            if (rbmpSelected.equals(false) && rbrpSelected.equals(false) && rbtarjSelected.equals(false)){
                    Toast.makeText(this, "Debes seleccionar una opcion antes de poder continuar", Toast.LENGTH_SHORT).show()
                }
                else{
                    val i = Intent(this, ConfirmarCompraActivity::class.java)
                    when {
                        rbmpSelected.equals(true) -> {
                            i.putExtra("Mercado Pago", "Mercado Pago")
                        }
                        rbrpSelected.equals(true) -> {
                            i.putExtra("Rapi Pago", "Rapi Pago / Pago facil")
                        }
                        rbtarjSelected.equals(true) -> {
                            i.putExtra("Tarjeta", "Debito / Credito")
                            i.putExtra("Numero Tarjeta", numTarjeta.text)
                        }
                    }
                    i.putExtra("Envio", envio.text.toString())
                    i.putExtra("Precio", findViewById<TextView>(R.id.precio_comprar).text.toString())
                    i.putExtra("Descripcion", descripcionProd.text.toString())
                    i.putExtra("Imagen", url.text.toString())
                    startActivity(i)
                }
        }
    }
}