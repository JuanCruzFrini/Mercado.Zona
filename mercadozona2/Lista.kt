package com.example.mercadozona2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mercadozona2.Adapters.MiAdaptador


@Suppress("UNCHECKED_CAST")
class Lista : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adaptador: MiAdaptador? = null

    override fun onCreate(savedInstanceBundle: Bundle?) {
        super.onCreate(savedInstanceBundle)
        setContentView(R.layout.lista)
        recyclerView = findViewById(R.id.recycler_view)

        when {
            intent.hasExtra("Smartphones") -> adaptador = MiAdaptador(this, MainActivity.almacenSmartphones.listaElementos(1) as List<String>, MainActivity.almacenSmartphones.listaPrecios(1) as List<String>, MainActivity.almacenSmartphones.imagenes(10) as List<String>)
            intent.hasExtra("Electrodomesticos") -> adaptador = MiAdaptador(this, MainActivity.almacenElectros.listaElementos(10) as List<String>, MainActivity.almacenElectros.listaPrecios(10) as List<String>, MainActivity.almacenElectros.imagenes(10) as List<String>)
            intent.hasExtra("Super") -> adaptador = MiAdaptador(this, MainActivity.almacenSuper.listaElementos(10) as List<String>, MainActivity.almacenSuper.listaPrecios(10) as List<String>, MainActivity.almacenSuper.imagenes(10) as List<String>)
            intent.hasExtra("Ferreteria") -> adaptador = MiAdaptador(this, MainActivity.almacenFerreteria.listaElementos(10) as List<String>, MainActivity.almacenFerreteria.listaPrecios(10) as List<String>, MainActivity.almacenFerreteria.imagenes(10) as List<String>)
            intent.hasExtra("Farmacia") -> adaptador = MiAdaptador(this, MainActivity.almacenFarmacia.listaElementos(10) as List<String>, MainActivity.almacenFarmacia.listaPrecios(10) as List<String>, MainActivity.almacenFarmacia.imagenes(10) as List<String>)
            intent.hasExtra("Bazar") -> adaptador = MiAdaptador(this, MainActivity.almacenBazar.listaElementos(10) as List<String>, MainActivity.almacenBazar.listaPrecios(10) as List<String>, MainActivity.almacenBazar.imagenes(10) as List<String>)
            intent.hasExtra("Ropa") -> adaptador = MiAdaptador(this, MainActivity.almacenRopa.listaElementos(10) as List<String>, MainActivity.almacenRopa.listaPrecios(10) as List<String>, MainActivity.almacenRopa.imagenes(10) as List<String>)
            intent.hasExtra("Deportes") -> adaptador = MiAdaptador(this, MainActivity.almacenDeportes.listaElementos(10) as List<String>, MainActivity.almacenDeportes.listaPrecios(10) as List<String>, MainActivity.almacenDeportes.imagenes(10) as List<String>)
            intent.hasExtra("Ofertas") -> adaptador = MiAdaptador(this, MainActivity.almacenOfertas.listaElementos(10) as List<String>, MainActivity.almacenOfertas.listaPrecios(10) as List<String>, MainActivity.almacenOfertas.imagenes(10) as List<String>)
            //intent.hasExtra("AppAbierta") == false -> adaptador = MiAdaptador(this, MainActivity.FragmentMainArray.listaElementos(10) as List<String>, MainActivity.FragmentMainArray.listaPrecios(10) as List<String>)
        }
        //adaptador = MiAdaptador(this, lista = MainActivity.almacenSmartphones.listaElementos(10) as List<String>, listaPrecios = MainActivity.Companion.almacenSmartphones.listaPrecios(10) as List<String>)

        recyclerView!!.adapter = adaptador

        layoutManager = LinearLayoutManager(this)
        //layoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //lanzador Carrito Activity
        findViewById<ImageButton>(R.id.carritoNav).setOnClickListener { startActivity(Intent(this, CarritoActivity::class.java)) }

        //lanzador perfil activity
        findViewById<ImageButton>(R.id.perfilbtn).setOnClickListener { startActivity(Intent(this, PerfilActivity::class.java)) }
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


}