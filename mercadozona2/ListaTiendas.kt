package com.example.mercadozona2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadozona2.Adapters.AdaptadorTiendasFirebase
import com.example.mercadozona2.FirebaseFirestore.MainViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_lista_tiendas.*

class ListaTiendas : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val adapter = AdaptadorTiendasFirebase(this)
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tiendas)

        //recycler desde el array
        /*val adapter: AdaptadorTiendas = AdaptadorTiendas(this,
                MainActivity.almacenTiendas.listaNombres(10) as List<String>,
                MainActivity.almacenTiendas.listaUbicacion(10) as List<String>,
                MainActivity.almacenTiendas.rubro(10) as List<String>,
                MainActivity.almacenTiendas.imagenes(10) as List<String>)

        recycler_view_tiendas.adapter = adapter
        recycler_view_tiendas.layoutManager = LinearLayoutManager(this)*/

        //recycler desde Firebase
        recycler_view_tiendas.adapter = adapter
        recycler_view_tiendas.layoutManager = LinearLayoutManager(this)
        recycler_view_tiendas.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        //lanzador Carrito Activity
        findViewById<ImageButton>(R.id.carritoNav).setOnClickListener { startActivity(Intent(this, CarritoActivity::class.java)) }

        //lanzador perfil activity
        findViewById<ImageButton>(R.id.perfilbtn).setOnClickListener { startActivity(Intent(this, PerfilActivity::class.java)) }

        //ubicacion dinamica
        val prefs = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE)
        val localidad = findViewById<TextView>(R.id.localidad_perfil)
        localidad.setText(prefs.getString("localidad", "").toString())

        observeData(prefs.getString("pais","").toString(), prefs.getString("provincia","").toString(), prefs.getString("localidad", "").toString())
    }

    fun tienda(view: View){
        val nombre = view.findViewById<TextView>(R.id.nombre_tienda)
        val ubicacion = view.findViewById<TextView>(R.id.ubicacion_tienda)
        val rubro = view.findViewById<TextView>(R.id.rubro)
        val url = view.findViewById<TextView>(R.id.urlimg)

        startActivity(
            Intent(this, PerfilVendedorActivity::class.java)
                .putExtra("Nombre", nombre.text.toString())
                .putExtra("Ubicacion", ubicacion.text.toString())
                .putExtra("${rubro.text}", "${rubro.text}")
                .putExtra("Imagen", url.text)
        )
    }

    fun observeData(pais: String?, provincia:String?, localidad:String?){
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        viewModel.fetchTiendaData(pais, provincia, localidad).observe(this, Observer {
            /*shimmer_container.stopShimmer()
            shimmer_container.hideShimmer()
            shimmer_container.visibility = View.GONE*/
            adapter.setListTiendasData(it)
            adapter.notifyDataSetChanged()
        })
    }
}