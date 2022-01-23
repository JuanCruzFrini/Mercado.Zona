package com.example.mercadozona2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadozona2.Adapters.AdaptadorTiendasFirebase
import com.example.mercadozona2.Adapters.MiAdaptador
import com.example.mercadozona2.ArrayTiendas.AlmacenTiendas
import com.example.mercadozona2.ArrayTiendas.AlmacenTiendasArray
import com.example.mercadozona2.ArraysCategorias.*
import com.example.mercadozona2.FirebaseFirestore.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapterFireBaseTiendas = AdaptadorTiendasFirebase(this)
    val viewModel = MainViewModel()

    companion object {
        var almacenSmartphones: AlmacenElementos = AlmacenSmartphonesArray()
        var almacenElectros: AlmacenElementos = AlmacenElectrosArray()
        var almacenSuper: AlmacenElementos = AlmacenSuperArray()
        var almacenFerreteria: AlmacenElementos = AlmacenFerreteriaArray()
        var almacenFarmacia: AlmacenElementos = AlmacenFarmaciaArray()
        var almacenBazar: AlmacenElementos = AlmacenBazarArray()
        var almacenRopa: AlmacenElementos = AlmacenRopaArray()
        var almacenDeportes: AlmacenElementos = AlmacenDeportesArray()
        var almacenOfertas: AlmacenElementos = AlmacenOfertasArray()
        var almacenTiendas: AlmacenTiendas = AlmacenTiendasArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        //splashscreen
        //setTheme(R.style.Theme_MercadoZona2)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //println(MainViewModel().prefs().getPrefs())

        //lanzar animacion splash screen
        if (!intent.hasExtra("AppAbierta")){ startActivity(Intent(this, SplashScreen::class.java)
            .putExtra("AppAbierta", true)
        ) }

        //recyclers flotantes main cargados con arrays
        recycler_view_main_ofertas.adapter = MiAdaptador(this, almacenOfertas.listaElementos(10) as List<String>, almacenOfertas.listaPrecios(10)as List<String>, almacenOfertas.imagenes(10) as List<String>)
        recycler_view_main_ofertas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_main_ofertas.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        recycler_view_main_smartphones.adapter = MiAdaptador(this, almacenSmartphones.listaElementos(5) as List<String>, almacenSmartphones.listaPrecios(5) as List<String>, almacenSmartphones.imagenes(10) as List<String>)
        recycler_view_main_smartphones.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_main_smartphones.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
       /* recycler_view_main_smartphones.layoutManager = LinearLayoutManager(this) //GridLayoutManager(this, 2)
        recycler_view_main_smartphones.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))*/

        recycler_view_main_super.adapter = MiAdaptador(this, almacenSuper.listaElementos(5) as List<String>, almacenSuper.listaPrecios(5) as List<String>, almacenSuper.imagenes(10) as List<String>)
        recycler_view_main_super.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_main_super.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))
        /*recycler_view_main_super.layoutManager = LinearLayoutManager(this)
        recycler_view_main_super.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))*/

        recycler_view_main_ropa.adapter = MiAdaptador(this, almacenRopa.listaElementos(5) as List<String>, almacenRopa.listaPrecios(5) as List<String>, almacenRopa.imagenes(10) as List<String>)
        recycler_view_main_ropa.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view_main_ropa.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        /*recycler_view_main_tiendas.adapter = AdaptadorTiendas(this, almacenTiendas.listaNombres(5) as List<String>, almacenTiendas.listaUbicacion(5) as List<String>, almacenTiendas.rubro(5) as List<String>, almacenTiendas.imagenes(10) as List<String>)
        recycler_view_main_tiendas.layoutManager = LinearLayoutManager(this)
        recycler_view_main_tiendas.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))*/

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)

        //recyclers flotantes main cargados con firebase cloud firestore
        recycler_view_main_tiendas.adapter = adapterFireBaseTiendas
        recycler_view_main_tiendas.layoutManager = LinearLayoutManager(this)
        recycler_view_main_tiendas.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        observeTiendasData(prefs.getString("pais", "").toString(), prefs.getString("provincia","").toString(), prefs.getString("localidad", "").toString())


        //nav
        //lanzador Carrito Activity
        findViewById<ImageButton>(R.id.carritoNav).setOnClickListener { startActivity(Intent(this, CarritoActivity::class.java)) }
        //lanzador perfil activity
        findViewById<ImageButton>(R.id.perfilbtn).setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
            overridePendingTransition(R.anim.entrada_izq, R.anim.anim_estatica)}

        //botones bajo el nav
        //lanzamos Recycler super
        findViewById<ImageButton>(R.id.superbtn).setOnClickListener { startActivity(Intent(this, Lista::class.java).putExtra("Super", "Super")) }
        //lanzamos categorias
        findViewById<ImageButton>(R.id.categoriasbtn).setOnClickListener {
            startActivity(Intent(this, CategoriasActivity::class.java))
            overridePendingTransition(R.anim.entrada_arriba, R.anim.anim_estatica)}
        //lanzamos Recycler Ofertas
        findViewById<ImageButton>(R.id.ofertasbtn).setOnClickListener { startActivity(Intent(this, Lista::class.java).putExtra("Ofertas", "Ofertas")) }

        //ampliar recyclers flotantes main
        //lanzamos recycler ofertas
        ofertastxt.setOnClickListener { startActivity(Intent(this, Lista::class.java).putExtra("Ofertas", "Ofertas")) }
        //lanzamos Recycler smartphones
        smartphonestxt.setOnClickListener { startActivity(Intent(this, Lista::class.java).putExtra("Smartphones", "Smartphones")) }
        //lanzamos Recycler tiendas
        tiendastxt.setOnClickListener { startActivity(Intent(this, ListaTiendas::class.java).putExtra("Tiendas", "Tiendas")) }
        //lanzamos Recycler super
        supertxt.setOnClickListener { startActivity(Intent(this, Lista::class.java).putExtra("Super", "Super")) }
        //lanzamos Recycler ropa
        modatxt.setOnClickListener { startActivity(Intent(this, Lista::class.java).putExtra("Ropa", "Ropa")) }


        //lanzamos buscador
        lupa.setOnClickListener {
            consulta.text = buscador.text.toString()
            if (consulta.text.isNotEmpty()){ startActivity(Intent(this, SearchActivity::class.java).putExtra("consulta", consulta.text.toString())) }
            else {Toast.makeText(this, "Debe escribir algo para poder realizar la busqueda", Toast.LENGTH_SHORT).show()}
        }


        //imagen_info.setImageResource(R.drawable.logo_radar)

        /*//lanzador producto activity
        val envio = findViewById<TextView>(R.id.envio_mainActivity)
        findViewById<LinearLayout>(R.id.container_articulo).setOnClickListener {
            val i = Intent(this, ProductoActivity::class.java)
            if (envio.equals("¡Envio gratis!")){
                i.putExtra("Envio", "Gratis")
            } else {
                i.putExtra("Envio", envio.text)
            }
                i.putExtra("Descripcion", findViewById<TextView>(R.id.descripcion_main).text.toString())
                i.putExtra("Precio", findViewById<TextView>(R.id.precio_info).text.toString())
                i.putExtra("Imagen", findViewById<ImageView>(R.id.imagen_info).resources.toString())
            startActivity(i)
        }

        //animacion agregar a favoritos
        val favorito = findViewById<ImageButton>(R.id.favorito)
        val favoritoOC = findViewById<ImageButton>(R.id.favoritoOC)

        favorito.setOnClickListener{
            favorito.visibility = View.GONE
            favoritoOC.visibility = View.VISIBLE
            Toast.makeText(this, "Articulo agregado a lista de favoritos", Toast.LENGTH_SHORT).show()
        }

        favoritoOC.setOnClickListener {
            favorito.visibility = View.VISIBLE
            favoritoOC.visibility = View.GONE
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
        //i.putExtra("Vendedor", findViewById<TextView>(R.id.nombreVendedor).text.toString())
        startActivity(i)
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

    fun observeTiendasData(pais:String?, provincia:String?, localidad:String?){
        viewModel.fetchTiendaData(pais, provincia, localidad).observe(this, Observer {
            adapterFireBaseTiendas.setListTiendasData(it)
            adapterFireBaseTiendas.notifyDataSetChanged()
        })
    }
}