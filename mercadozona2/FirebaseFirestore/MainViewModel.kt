package com.example.mercadozona2.FirebaseFirestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mercadozona2.Producto
import com.example.mercadozona2.Tienda

class MainViewModel: ViewModel() {
    val repo = Repo()

    fun fetchProductoData(pais: String?, provincia:String?, localidad:String?, tienda:String?): LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        repo.getProductoData(pais, provincia, localidad, tienda).observeForever{
            mutableData.value = it
        }
        return mutableData
    }

    fun fetchProductoSearchData(pais: String?, provincia:String?, localidad:String?, consulta:String?): LiveData<MutableList<Producto>>{
        val mutableData = MutableLiveData<MutableList<Producto>>()
        repo.getProductoPorSearch(pais, provincia, localidad, consulta).observeForever{
            mutableData.value = it
        }
        return mutableData
    }

    fun fetchTiendaData(pais: String?, provincia:String?, localidad:String?): LiveData<MutableList<Tienda>>{
       // val prefs = prefs().getPrefs()
        val mutableData = MutableLiveData<MutableList<Tienda>>()
        //repo.getTiendaData(prefs.get("pais").toString(),prefs.get("provincia").toString(), prefs.get("localidad").toString()) .observeForever {
        repo.getTiendaData(pais, provincia, localidad) .observeForever {
            mutableData.value = it
        }
        return mutableData
    }

/*
    inner class prefs:AppCompatActivity(){
        fun getPrefs(): Map<String, String>{
            //val mapa = mutableMapOf<String, String>()
            val prefs:SharedPreferences? = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
            val pais = prefs?.getString("pais", "")
            val provin = prefs?.getString("provincia", "")
            val localidad = prefs?.getString("localidad", "")
            //mapa.putAll("pais", "$pais", "provincia", "$provin", "localidad", "$localidad")
            return mapOf("pais" to "${pais.toString()}", "provincia" to provin.toString(), "localidad" to "${localidad.toString()}")
        }
    }
*/
}