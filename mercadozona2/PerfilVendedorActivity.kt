 package com.example.mercadozona2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mercadozona2.Adapters.MiAdaptador
import com.example.mercadozona2.Adapters.MiAdaptadorFirebase
import com.example.mercadozona2.FirebaseFirestore.MainViewModel
import kotlinx.android.synthetic.main.activity_perfil_vendedor.*

 class PerfilVendedorActivity : AppCompatActivity() {

     val viewModel = MainViewModel()
     val adapter = MiAdaptadorFirebase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_vendedor)

        var adaptador: MiAdaptador? = null
        var rubro = findViewById<TextView>(R.id.rubro)

        //usado para mostar los distintos perfiles de tiendas, hechos en Arrays
        /*when {
            intent.hasExtra("Smartphones") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenSmartphones.listaElementos(1) as List<String>, MainActivity.almacenSmartphones.listaPrecios(1) as List<String>, MainActivity.almacenSmartphones.imagenes(10) as List<String>)
                intent.putExtra("Smartphones","Smartphones")
                rubro.text = "Smartphones"
            }
            intent.hasExtra("Electrodomesticos") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenElectros.listaElementos(10) as List<String>, MainActivity.almacenElectros.listaPrecios(10) as List<String>, MainActivity.almacenElectros.imagenes(10) as List<String>)
                intent.putExtra("Electrodomesticos", "Electrodomesticos")
                rubro.text = "Electrodomesticos"
            }
            intent.hasExtra("Super") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenSuper.listaElementos(10) as List<String>, MainActivity.almacenSuper.listaPrecios(10) as List<String>, MainActivity.almacenSuper.imagenes(10) as List<String>)
                intent.putExtra("Super", "Super")
                rubro.text = "Super"
            }
            intent.hasExtra("Ferreteria") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenFerreteria.listaElementos(10) as List<String>, MainActivity.almacenFerreteria.listaPrecios(10) as List<String>, MainActivity.almacenFerreteria.imagenes(10) as List<String>)
                intent.putExtra("Ferreteria", "Ferreteria")
                rubro.text = "Ferreteria"
            }
            intent.hasExtra("Farmacia") ->{
                adaptador = MiAdaptador(this, MainActivity.almacenFarmacia.listaElementos(10) as List<String>, MainActivity.almacenFarmacia.listaPrecios(10) as List<String>, MainActivity.almacenFarmacia.imagenes(10) as List<String>)
                intent.putExtra("Farmacia", "Farmacia")
                rubro.text = "Farmacia"
            }
            intent.hasExtra("Bazar") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenBazar.listaElementos(10) as List<String>, MainActivity.almacenBazar.listaPrecios(10) as List<String>, MainActivity.almacenBazar.imagenes(10) as List<String>)
                intent.putExtra("Bazar", "Bazar")
                rubro.text = "Bazar"
            }
            intent.hasExtra("Ropa") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenRopa.listaElementos(10) as List<String>, MainActivity.almacenRopa.listaPrecios(10) as List<String>, MainActivity.almacenRopa.imagenes(10) as List<String>)
                intent.putExtra("Ropa", "Ropa")
                rubro.text = "Ropa"
            }
            intent.hasExtra("Deportes") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenDeportes.listaElementos(10) as List<String>, MainActivity.almacenDeportes.listaPrecios(10) as List<String>, MainActivity.almacenDeportes.imagenes(10) as List<String>)
                intent.putExtra("Deportes", "Deportes")
                rubro.text = "Deportes"
            }
            intent.hasExtra("Ofertas") -> {
                adaptador = MiAdaptador(this, MainActivity.almacenOfertas.listaElementos(10) as List<String>, MainActivity.almacenOfertas.listaPrecios(10) as List<String>, MainActivity.almacenOfertas.imagenes(10) as List<String>)
                intent.putExtra("Ofertas", "Ofertas")
                rubro.text = "Ofertas"
            }
        }*/
        //recycler_view_perf_vendedor.adapter = adaptador

        recycler_view_perf_vendedor.adapter = adapter
        recycler_view_perf_vendedor.layoutManager = LinearLayoutManager(this)
        recycler_view_perf_vendedor.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val nombreTienda = findViewById<TextView>(R.id.nombreVendedor)
        nombreTienda.text = intent.getStringExtra("Nombre").toString()

        val calle = findViewById<TextView>(R.id.calle_vendedor)
        calle.text = intent.getStringExtra("Ubicacion").toString()

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val localidad = findViewById<TextView>(R.id.localidad_vendedor)
        localidad.setText(prefs.getString("localidad","").toString())

        val img = findViewById<ImageView>(R.id.imagen_info)
        Glide.with(this)
            .load(intent.getStringExtra("Imagen"))
            .error(R.drawable.superr)
            .placeholder(R.drawable.superr)
            .into(img)

        observeData(prefs.getString("pais","").toString(), prefs.getString("provincia","").toString(), prefs.getString("localidad", "").toString(), nombreTienda.text.toString())
    }

     fun producto(view: View) {
         //ELEMENTAL EL USO DE "VIEW. " ANTES DEL FINDVBID PARA QUE TOME LA INFO DEL ITEM SELECCIONADO,
         //SINO TOMA LA DEL PRIMERO EL HIJO DE RE MIL PUTA 2 DIAS ESTUVE PARA DARME CUENTA
         val descrpicion = view.findViewById<TextView>(R.id.descripcion_main)
         val envio = view.findViewById<TextView>(R.id.envio_mainActivity)
         val precio = view.findViewById<TextView>(R.id.precio_rv)
         val url = view.findViewById<TextView>(R.id.urlimg)
         val vendedor = findViewById<TextView>(R.id.nombreVendedor)
         val i = Intent(this, ProductoActivity::class.java)
         i.putExtra("Envio", envio.text)
         i.putExtra("Precio", precio.text)
         i.putExtra("Descripcion", descrpicion.text)
         i.putExtra("Imagen", url.text)
         i.putExtra("Ubicacion", intent.getStringExtra("Ubicacion").toString())
         i.putExtra("${rubro.text}", rubro.text.toString())
         i.putExtra("ImagenLogo", intent.getStringExtra("Imagen"))
         i.putExtra("Vendedor", vendedor.text)
         startActivity(i)
     }

    fun seguir(view: View?){
        val botonSeguir = findViewById<Button>(R.id.seguirbtn)
        val botonSiguiendo = findViewById<Button>(R.id.siguiendobtn)
        botonSeguir.visibility = View.GONE
        botonSiguiendo.visibility = View.VISIBLE
    }

    fun dejarSeguir(view: View?){
        val botonSeguir = findViewById<Button>(R.id.seguirbtn)
        val botonSiguiendo = findViewById<Button>(R.id.siguiendobtn)
        botonSeguir.visibility = View.VISIBLE
        botonSiguiendo.visibility = View.GONE
    }

     fun observeData(pais: String?, provincia:String?, localidad:String?, tienda:String?){
         viewModel.fetchProductoData(pais, provincia, localidad, tienda).observe(this, Observer {
             adapter.setListData(it)
             adapter.notifyDataSetChanged()
         })
     }

 }