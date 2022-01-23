package com.example.mercadozona2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadozona2.Adapters.MiAdaptadorFirebase
import com.example.mercadozona2.FirebaseFirestore.MainViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_perfil_empresa.*

class PerfilEmpresaActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val adapter = MiAdaptadorFirebase(this)
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_perfil_empresa)

            val recycler = findViewById<RecyclerView>(R.id.recycler_view_perf_empresa)
            recycler.adapter = adapter// MiAdaptador(this, MainActivity.almacenFirebase.listaElementos(10) as List<String>, MainActivity.almacenFirebase.listaPrecios(10) as List<String>, MainActivity.almacenFirebase.imagenes(10))
            recycler.layoutManager = LinearLayoutManager(this)
            recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
            //val prefsEditor:SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()

            //if (prefs.contains("nombreMiTienda")){ nombreEt.setText(prefs.getString("nombreMiTienda","").toString()) }

            observeData(prefs.getString("pais","").toString(), prefs.getString("provincia","").toString(), prefs.getString("localidad", "").toString(), nombreEt.text.toString())


            //agregar Articulo bton
            findViewById<Button>(R.id.agregarProductosbtn).setOnClickListener { startActivity(Intent(this, AgregarArticuloActivity::class.java)) }

            //Edicion de perfil
            val botonEdit = findViewById<Button>(R.id.editarbtn)
            val nombre = findViewById<EditText>(R.id.nombreEt)
            val localidad = findViewById<EditText>(R.id.localidadEt_perfEmpresa)
            val direccion = findViewById<EditText>(R.id.calleEt)
            val botonGuardar = findViewById<Button>(R.id.guardarbtn)

            localidad.isEnabled = false
            direccion.isEnabled = false
            nombre.isEnabled = false

            botonEdit.setOnClickListener {
                localidad.isEnabled = true
                direccion.isEnabled = true
                nombre.isEnabled = true
                botonEdit.visibility = View.GONE
                botonGuardar.visibility = View.VISIBLE
            }

            botonGuardar.setOnClickListener {
                localidad.isEnabled = false
                direccion.isEnabled = false
                nombre.isEnabled = false
                botonEdit.visibility = View.VISIBLE
                botonGuardar.visibility = View.GONE
                direccion.text = direccion.text
                nombre.text = nombre.text
                //prefsEditor.putString("nombreMiTienda", nombre.text.toString())
                //prefsEditor.putString("nombreMiTienda", nombre.text.toString())
                //nombre.setText(prefs.getString("nombreMiTienda", "").toString())

            }

            /* //editar stock button
             val stock1 = findViewById<EditText>(R.id.stock)
             stock1.isEnabled = false
             val stock2 = findViewById<EditText>(R.id.stock2)
             stock2.isEnabled = false
             val x1 = findViewById<Button>(R.id.botonX_carrito)
             val x2 = findViewById<Button>(R.id.botonX_carrito2)
             val guardarCambiosBtn = findViewById<Button>(R.id.guardarCambiosbtn)
             val botonEditarStock =findViewById<Button>(R.id.editarStockbtn)
             val Art1 = findViewById<EditText>(R.id.articuloEt_perfilEmp)
             val Art2 = findViewById<EditText>(R.id.articuloEt_perfilEmp2)
             val desc1 = findViewById<EditText>(R.id.descripcionEt_perfEmp)
             val desc2 = findViewById<EditText>(R.id.descripcionEt_perfEmp2)
             val precio1 = findViewById<EditText>(R.id.precioEt_perfEmp)
             val precio2 = findViewById<EditText>(R.id.precioEt_perfEmp2)
             Art1.isEnabled = false
             Art2.isEnabled = false
             desc1.isEnabled = false
             desc2.isEnabled = false
             precio1.isEnabled = false
             precio2.isEnabled = false


             botonEditarStock.setOnClickListener {
                 x1.visibility = View.VISIBLE
                 x2.visibility = View.VISIBLE
                 Art1.isEnabled = true
                 Art2.isEnabled = true
                 desc1.isEnabled = true
                 desc2.isEnabled = true
                 precio1.isEnabled = true
                 precio2.isEnabled = true
                 stock1.isEnabled = true
                 stock2.isEnabled = true
                 guardarCambiosBtn.visibility = View.VISIBLE
                 botonEditarStock.visibility = View.GONE
             }

             guardarCambiosBtn.setOnClickListener {
                 x1.visibility = View.GONE
                 x2.visibility = View.GONE
                 Art1.isEnabled = false
                 Art2.isEnabled = false
                 desc1.isEnabled = false
                 desc2.isEnabled = false
                 precio1.isEnabled = false
                 precio2.isEnabled = false
                 stock1.isEnabled = false
                 stock2.isEnabled = false
                 guardarCambiosBtn.visibility = View.GONE
                 botonEditarStock.visibility = View.VISIBLE
             }

             x1.setOnClickListener {
                 findViewById<LinearLayout>(R.id.container_articulo).visibility = View.GONE
             }

             x2.setOnClickListener {
                 findViewById<LinearLayout>(R.id.container_articulo2).visibility = View.GONE
             }*/
        }

    fun producto(view: View) {
        //ELEMENTAL EL USO DE "VIEW. " ANTES DEL FINDVBID PARA QUE TOME LA INFO DEL ITEM SELECCIONADO,
        //SINO TOMA LA DEL PRIMERO EL HIJO DE RE MIL PUTA 2 DIAS ESTUVE PARA DARME CUENTA
        val descrpicion = view.findViewById<TextView>(R.id.descripcion_main)
        val envio = view.findViewById<TextView>(R.id.envio_mainActivity)
        val precio = view.findViewById<TextView>(R.id.precio_rv)
        val url = view.findViewById<TextView>(R.id.urlimg)
        val i = Intent(this, ProductoActivity::class.java)
        i.putExtra("Envio", envio.text)
        i.putExtra("Precio", precio.text)
        i.putExtra("Descripcion", descrpicion.text)
        i.putExtra("Imagen", url.text)
        startActivity(i)
    }

    fun observeData(pais: String?, provincia:String?, localidad:String?, tienda:String?){
        shimmer_container.startShimmer()
        //viewModel.repo.getProductoData().observe(this, Observer {
            viewModel.fetchProductoData(pais, provincia, localidad, tienda).observe(this, Observer {
            shimmer_container.stopShimmer()
            shimmer_container.hideShimmer()
            shimmer_container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

}