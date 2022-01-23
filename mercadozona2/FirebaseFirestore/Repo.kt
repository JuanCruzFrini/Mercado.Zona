package com.example.mercadozona2.FirebaseFirestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mercadozona2.Producto
import com.example.mercadozona2.Tienda
import com.google.firebase.firestore.FirebaseFirestore

@Suppress("UNREACHABLE_CODE")
class Repo {

    fun getProductoPorSearch (pais: String?, provincia:String?, localidad:String?, consulta:String?): LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        FirebaseFirestore.getInstance().collection("/pais/${pais.toString()}/provincias/${provincia.toString()}/localidades/${localidad.toString()}/tiendas"/*/${tienda.toString()}/productos*/)
            .get().addOnSuccessListener { listaTiendas ->
                val listData: MutableList<Producto> = mutableListOf<Producto>()
                for (tiendas in listaTiendas) {
                    println("nombre tienda: ${tiendas.id}")
                    println("datos tienda: ${tiendas.data}")

                    FirebaseFirestore.getInstance().collection("/pais/${pais.toString()}/provincias/${provincia.toString()}/localidades/${localidad.toString()}/tiendas/${tiendas.id.toString()}/productos/")
                        //.whereEqualTo("descripcion", consulta.toString())
                        .get().addOnSuccessListener { productos ->
                            println(consulta)
                            println(productos.size())

                            for (producto in productos){
                                println(consulta + consulta)

                                //val listData: MutableList<Producto> = mutableListOf<Producto>()
                            val descripcion: String = producto.getString("descripcion").toString()
                            val precio: String = producto.getString("precio").toString()
                            val imagen: String = producto.getString("imagen").toString()
                            val stock: String = producto.getString("stock").toString()
                            val rubro: String = producto.getString("rubro").toString()
                            val productoFinal = Producto(descripcion, stock, precio, imagen)
                            println("prodfinal: " + productoFinal)
                            listData.add(productoFinal)
                                println("lista data: "+listData)
                            mutableData.value = listData
                            }
                            mutableData.value = listData
                        }
                    mutableData.value = listData
                    println("mutabledata: ${mutableData.value}")
                }
            }
        return mutableData
    }

    fun getProductoData(pais: String?, provincia:String?, localidad:String?, tienda:String?): LiveData<MutableList<Producto>> {

        val mutableData = MutableLiveData<MutableList<Producto>>()
        FirebaseFirestore.getInstance()
            .collection("/pais/${pais.toString()}/provincias/${provincia.toString()}/localidades/${localidad.toString()}/tiendas/${tienda.toString()}/productos")
            .get().addOnSuccessListener { listaProductos ->
                val listData: MutableList<Producto> = mutableListOf<Producto>()
                            for (productos in listaProductos) {
                                println("Producto: ${productos.id}")
                                println("Producto: ${productos.data}")

                                //val listData: MutableList<Producto> = mutableListOf<Producto>()
                                val descripcion: String = productos.getString("descripcion").toString()
                                val precio: String = productos.getString("precio").toString()
                                val imagen: String = productos.getString("imagen").toString()
                                val stock: String = productos.getString("stock").toString()
                                val rubro: String = productos.getString("rubro").toString()
                                val producto = Producto(descripcion, stock, precio, imagen)
                                println("descripcion: " + producto.descripcion)
                                listData.add(producto)
                                mutableData.value = listData
                            }
                            mutableData.value = listData
                            println("mutabledata: ${mutableData.value}")
                        }
        return mutableData
    }
        /*
        Este deberia mostrar todos los productos que hay en todas las tiendas de una localidad,
        anda pero no carga todo el contenido, y los carga de manera aleatoria, a veces a unos
        y otras a otros, pero no siempre a los mismos, el codigo funciona para la llamada a
        la funcion "getProductodata()", sin argumentos ()
        */
        /*fun getProductoData(): LiveData<MutableList<Producto>> {
        val mutableData = MutableLiveData<MutableList<Producto>>()
        FirebaseFirestore.getInstance()
            .collection("/pais/Argentina/provincias/Cordoba/localidades/Santa Rosa de Calamuchita/tiendas")
            .get().addOnSuccessListener { tiendas ->
                val listData: MutableList<Producto> = mutableListOf<Producto>()

                for (tienda in tiendas) {
                    println("Tienda: ${tienda.id}")
                    FirebaseFirestore.getInstance()
                        .collection("/pais/Argentina/provincias/Cordoba/localidades/Santa Rosa de Calamuchita/tiendas/${tienda.id}/productos")
                        .get().addOnSuccessListener { productosTienda ->

                            for (productos in productosTienda) {
                                println("Producto: ${productos.id}")
                                println("Producto: ${productos.data}")

                                //val listData: MutableList<Producto> = mutableListOf<Producto>()
                                val descripcion: String = productos.getString("descripcion").toString()
                                val precio: String = productos.getString("precio").toString()
                                val imagen: String = productos.getString("imagen").toString()
                                val stock: String = productos.getString("stock").toString()
                                val rubro: String = productos.getString("rubro").toString()
                                val producto = Producto(descripcion, stock, precio, imagen)
                                println("descripcion: " + producto.descripcion)
                                listData.add(producto)
                                mutableData.value = listData
                            }
                            mutableData.value = listData
                            println("mutabledata: ${mutableData.value}")
                        }
                    mutableData.value = listData
                }
                mutableData.value = listData
            }
        return mutableData*/

    //obtencion de tiendas en base de datos firebase cloud firestore, dinamicamente de la ubicacion seleccionada de los
    //spinners Pais, Provincia y Localidad, del Activity Perfil, que fueron guardados en SharedPreferences
    fun getTiendaData(pais: String?, provincia:String?, localidad:String?): LiveData<MutableList<Tienda>> {

        Log.d("log:", pais +  provincia + localidad)
        val mutableTiendaData = MutableLiveData<MutableList<Tienda>>()

        FirebaseFirestore.getInstance().collection("/pais/${pais.toString() ?: "Argentina"}/provincias/${provincia.toString()?: "Cordoba"}/localidades/${localidad.toString()?: "Santa Rosa de Calamuchita"}/tiendas/").get().addOnSuccessListener { result ->
                val listaTiendas:MutableList<Tienda> = mutableListOf()

                for (tiendas in result) {
                    val nombre = tiendas.getString("nombre")
                    val ubicacion = tiendas.getString("ubicacion")
                    val rubro = tiendas.getString("rubro")
                    val imagen = tiendas.getString("imagen")
                    val tienda = Tienda(nombre.toString(), ubicacion.toString(), imagen.toString(), rubro.toString())
                    listaTiendas.add(tienda)
                }
                mutableTiendaData.value = listaTiendas
            }
        return mutableTiendaData
    }

        // ESTE ANDA PARA PRUEBA DE PRODUCTOS
        // FirebaseFirestore.getInstance().collection("producto").get().addOnSuccessListener{ result ->
        /*val listData: MutableList<Producto> = mutableListOf<Producto>()
            for (document in result){
                val descripcion:String = document.getString("descripcion").toString()
                val precio:String = document.getString("precio").toString()
                val imagen:String = document.getString("imagen").toString()
                val stock:String = document.getString("stock").toString()
                val rubro:String = document.getString("rubro").toString()
                val producto = Producto(descripcion, stock,precio,imagen)
                println("descripcion: "+producto.descripcion)
                listData.add(producto)
            }
            mutableData.value = listData*/

        ///ESTE ANDA PARA CARGAR LAS TIENDAS
        // FirebaseFirestore.getInstance().collection("pais").document("Argentina"/*prefs().pais.toString()*/).collection("provincias").document("Cordoba"/*prefs().provincia.toString()*/).collection("localidades").document("Santa Rosa de Calamuchita"/*prefs().localidad.toString()*/).collection("tiendas").get().addOnSuccessListener{ result ->
}