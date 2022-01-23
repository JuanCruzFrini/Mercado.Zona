package com.example.mercadozona2

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadozona2.Adapters.MiAdaptadorFirebase
import com.example.mercadozona2.FirebaseFirestore.MainViewModel
import com.example.mercadozona2.FirebaseFirestore.Repo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    val repo = Repo()
    val viewModel = MainViewModel()
    val adapter = MiAdaptadorFirebase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val prefs = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE)
        //consulta.text = buscador.toString()

        recycler_search.adapter = adapter
        recycler_search.layoutManager = LinearLayoutManager(this)
        recycler_search.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))


        observerBusquedaData(prefs.getString("pais","").toString(), prefs.getString("provincia","").toString(), prefs.getString("localidad",""), intent.getStringExtra("consulta").toString()?: ""/*buscador.toString()*/)

    }

/*
    fun observerData(){
        repo.getProductoPorSearch().observeForever {

        }
    }
*/

    fun observerBusquedaData(pais:String?, provincia:String?, localidad:String?, consulta:String?){
        viewModel.fetchProductoSearchData(pais, provincia, localidad, consulta).observe(this, androidx.lifecycle.Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

/*
    fun querySearch(pais: String?, provincia:String?, localidad:String?){
        db.collection("/pais/$pais/provincias/$provincia/localidades/$localidad/tiendas/")
    }
*/
}
