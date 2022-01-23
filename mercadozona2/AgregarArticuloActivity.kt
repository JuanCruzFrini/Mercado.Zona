package com.example.mercadozona2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class AgregarArticuloActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

   /* val marcaYmodelo = findViewById<EditText>(R.id.nombreProd_agregarArtActivity)
    //val descripcion = findViewById<EditText>(R.id.descripcionEt_perfEmp)
    val descripcion = findViewById<EditText>(R.id.descripcionProd_agregarArtActivity)
    //val precio = findViewById<EditText>(R.id.precioEt_perfEmp)
    val precio = findViewById<EditText>(R.id.precioProd_agregarArtActivity)
    val categoria = findViewById<EditText>(R.id.categoriaProd_agregarArtActivity)
    val stock = findViewById<EditText>(R.id.cantidadProd_agregarArtActivity)
    val imagenes = findViewById<EditText>(R.id.imagenesEt_agregarArtActivity)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_articulo)

        val marcaYmodelo = findViewById<EditText>(R.id.nombreProd_agregarArtActivity)
        //val descripcion = findViewById<EditText>(R.id.descripcionEt_perfEmp)
        val descripcion = findViewById<EditText>(R.id.descripcionProd_agregarArtActivity)
        //val precio = findViewById<EditText>(R.id.precioEt_perfEmp)
        val precio = findViewById<EditText>(R.id.precioProd_agregarArtActivity)
        val categoria = findViewById<EditText>(R.id.categoriaProd_agregarArtActivity)
        val stock = findViewById<EditText>(R.id.cantidadProd_agregarArtActivity)
        val imagenes = findViewById<EditText>(R.id.imagenesEt_agregarArtActivity)
        var n = 0
        //val producto = Producto(descripcion.text.toString(), marcaYmodelo.text.toString(),stock.text.toString(),precio.text.toString(), imagenes.text.toString())

        //agregar Articulo
        findViewById<Button>(R.id.continuarbtn).setOnClickListener {
            if (marcaYmodelo.text.isEmpty() || descripcion.text.isEmpty() || precio.text.isEmpty()
                || categoria.text.isEmpty() || stock.text.isEmpty() || imagenes.text.isEmpty()){
                Toast.makeText(this, "Debes completar todos los campos para agregar un nuevo articulo", Toast.LENGTH_SHORT).show()
            } else {
                //agregar(producto)
                //if (db.collection("tienda").document("producto").get().addOnSuccessListener { it.get("producto${n}") }){
                    db.collection("tienda").document("producto"/*${n++}*/).set(hashMapOf(
                    "producto" to "0", "descripcion" to descripcion.text.toString(), "precio" to precio.text.toString(),
                    "rubro" to categoria.text.toString(), "stock" to stock.text.toString(), "imagen" to imagenes.text.toString()))
                    n++
                //}
                startActivity(Intent(this, PerfilEmpresaActivity::class.java))
                //db.collection("tienda").document("producto").set(hashMapOf("producto" to "producto", "descripcion" to descripcion.text.toString(), "precio" to precio.text.toString(), "rubro" to categoria.text.toString(), "stock" to stock.text.toString(), "imagen" to imagenes.text.toString()))
            }
        }

        //cancelar Articulo
        findViewById<Button>(R.id.cancelarbtn).setOnClickListener { finish() }
    }
/*
    fun agregar(producto: Producto){
        db.collection("tienda").document("producto").set(
            hashMapOf("producto" to producto.toString())
                    //Producto(descripcion.text.toString(), marcaYmodelo.text.toString(), stock.text.toString(), precio.text.toString(), imagenes.text.toString(),  )
        )
    }
*/
}