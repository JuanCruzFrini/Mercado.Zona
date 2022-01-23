package com.example.mercadozona2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_perfil.*
import java.util.*

class PerfilActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    //instancia storage para imagenes
    //val mStorage:StorageReference = StorageReference()

    //instancia firestore
    private val db = FirebaseFirestore.getInstance()
    //private lateinit var rBinding: ActivityMainBinding
    private lateinit var provins: ArrayAdapter<String>
    private lateinit var localidades: ArrayAdapter<String>

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //rBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_perfil)

        //spinner paises
        val listPaises = listOf<String>("Argentina")
        val adapterPaises: ArrayAdapter<String> = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listPaises)
        paisSpinner.adapter = adapterPaises

        //spinner provins
        provins = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item)
        provins.addAll(Arrays.asList("Buenos Aires", "Cordoba", "Salta"))
        provinciaSpinner.onItemSelectedListener = this
        provinciaSpinner.adapter = provins

        //spinner localidades
        localidades = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item)


        //lanzar perfil empresa
        findViewById<LinearLayout>(R.id.miNegocio_perfilActivity).setOnClickListener { startActivity(Intent(this, PerfilEmpresaActivity::class.java)) }

        //lanzar registro
        findViewById<ImageView>(R.id.perfilbtn).setOnClickListener { startActivity(Intent(this, RegistroActivity::class.java)) }

        //lanzamos categorias
        findViewById<LinearLayout>(R.id.categoriasbtn).setOnClickListener { startActivity(Intent(this, CategoriasActivity::class.java)) }

        //lanzamos recycler ofertas
        findViewById<LinearLayout>(R.id.ofertasbtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Ofertas", "Ofertas"))
        }

        //lanzamos recycler tiendas
        findViewById<LinearLayout>(R.id.tiendasbtn).setOnClickListener { startActivity(Intent(this, ListaTiendas::class.java)) }

        //Edicion de perfil
        val botonEdit = findViewById<Button>(R.id.editarbtn)
        val nombre = findViewById<EditText>(R.id.nombreEt)
        val calle = findViewById<EditText>(R.id.calleEt)
        val altura = findViewById<EditText>(R.id.alturaEt)
        val botonGuardar = findViewById<Button>(R.id.guardarbtn)
        val buscar = findViewById<LinearLayout>(R.id.container_buscar)
        val dni = findViewById<EditText>(R.id.DniEt)
        val dniContainer = findViewById<LinearLayout>(R.id.dniContainer)
        val tarjeta = findViewById<EditText>(R.id.tarjEt)
        val tarjContainer = findViewById<LinearLayout>(R.id.tarjContainer)
        val localidadContainer = findViewById<LinearLayout>(R.id.localidadContainer)
        val pais = findViewById<TextView>(R.id.paisTv)
        val localidad = findViewById<TextView>(R.id.localidadSelected)
        val provincia = findViewById<TextView>(R.id.provinSelected)

        calle.isEnabled = false
        altura.isEnabled = false
        nombre.isEnabled = false

        botonEdit.setOnClickListener {
            calle.isEnabled = true
            altura.isEnabled = true
            nombre.isEnabled = true
            localidadContainer.visibility = View.VISIBLE
            dniContainer.visibility = View.VISIBLE
            tarjContainer.visibility = View.VISIBLE
            botonEdit.visibility = View.GONE
            botonGuardar.visibility = View.VISIBLE
            paisContainer.visibility = View.VISIBLE
            provinciaContainer.visibility = View.VISIBLE
            localidad_spinner.visibility = View.VISIBLE
        }

        botonGuardar.setOnClickListener {
            calle.isEnabled = false
            altura.isEnabled = false
            nombre.isEnabled = false
            localidadContainer.visibility = View.GONE
            dniContainer.visibility = View.GONE
            tarjContainer.visibility = View.GONE
            botonEdit.visibility = View.VISIBLE
            botonGuardar.visibility = View.GONE
            paisContainer.visibility = View.GONE
            provinciaContainer.visibility = View.GONE
            localidad_spinner.visibility = View.GONE
            localidad.text = localidad_spinner.selectedItem.toString()
            pais.text = paisSpinner.selectedItem.toString()

            //guardado de datos
            val prefs: SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.putString ("nombre", nombre.text.toString() ?: "")
            prefs.putString("calle", calle.text.toString() ?: "")
            prefs.putString("altura", altura.text.toString() ?: "")
            prefs.putString("dni", dni.text.toString())
            prefs.putString("tarjeta", tarjeta.text.toString())
            prefs.putString("localidad", localidad.text.toString())
            prefs.putString("provincia", provincia.text.toString())
            prefs.putString("pais", pais.text.toString())
            prefs.apply()
        }

        //obtencion de datos
        val prefsOk = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        calle.setText(prefsOk.getString("calle", ""))
        altura.setText(prefsOk.getString("altura", ""))
        nombre.setText(prefsOk.getString("nombre", ""))
        dni.setText(prefsOk.getString("dni", ""))
        tarjeta.setText(prefsOk.getString("tarjeta", ""))
        localidad.text = prefsOk.getString("localidad", "")
        pais.text = prefsOk.getString("pais", "")
        provincia.text = prefsOk.getString("provincia", "")
        //localidad_spinner.

        //buscar
        buscar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).putExtra("AppAbierta", true))
        }

        //lanzar carrito
        carrito.setOnClickListener { startActivity(Intent(this, CarritoActivity::class.java)) }

        //lanzar acercaDe
        acercaDe.setOnClickListener { startActivity(Intent(this, AcercaDe::class.java))}

        favoritoslist.setOnClickListener { Toast.makeText(this, "Funcion disponible proximamente!", Toast.LENGTH_SHORT).show() }
        historial.setOnClickListener { Toast.makeText(this, "Funcion disponible proximamente!", Toast.LENGTH_SHORT).show() }
        miscompras.setOnClickListener { Toast.makeText(this, "Funcion disponible proximamente!", Toast.LENGTH_SHORT).show() }

    }

    //metodos para el Spinner Provincias
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val provinselected = provins.getItem(position)
        provinSelected.text = provinselected
        localidades.clear()
        addLocs()
       /* val localidadSelected = localidades.getItem(position *//*-1*//*)
        localidadEt.setText(localidadSelected.toString())*/

    }

    //metodos para el Spinner Provincias
    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    //localidades en base a la provincia elegida
    fun addLocs(){
        when(provinSelected.text){
            "Buenos Aires" -> localidades.addAll("Bahia Blanca", "La Plata","CABA", "Tandil", "Villa Gesell", "Necochea","Monte Hermoso")
            "Cordoba" -> localidades.addAll("Santa Rosa de Calamuchita", "Villa Maria", "Villa Gral. Belgrano")
            "Salta" -> localidades.addAll("Salta")
        }
        localidad_spinner.adapter = localidades
        //localidadEt.text = localidades.getItem()
    }

    /*  //obtiene los paises en la lista pero no los muestra al seleccionarlos
    fun getPaises(): List<String>{
        val paises: MutableList<String> = ArrayList()
        db.collection("pais").get().addOnSuccessListener {
            for (documents in it)
                //val pais = documents.id
                paises.add(documents.id.toString())
        }
        val paiseslist:List<String> = paises
        return paiseslist
    }*/

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim_estatica, R.anim.entrada_der)
    }

}