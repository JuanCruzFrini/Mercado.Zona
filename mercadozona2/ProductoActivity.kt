package com.example.mercadozona2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        //completar campos con los datos extra del intent
        val descrpcionIntent = intent.getStringExtra("Descripcion").toString()
        val descripcionProd = findViewById<TextView>(R.id.descripcion_prod)
        descripcionProd.text = descrpcionIntent

        //llenado link vendedor
        val rubro = findViewById<TextView>(R.id.rubro)
        val vendedor = findViewById<TextView>(R.id.vendedorLink)
        if (intent.hasExtra("Vendedor")){vendedor.text = intent.getStringExtra("Vendedor").toString()}

       /* when {
            intent.hasExtra("Smartphones") -> rubro.text = "Smartphones" ?: "Vendedor no  encontrado"
            intent.hasExtra("Electrodomesticos") -> rubro.text = intent.getStringExtra("Electrodomesticos").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Super") -> rubro.text = intent.getStringExtra("Super").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Ferreteria") -> rubro.text = intent.getStringExtra("Ferreteria").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Farmacia") -> rubro.text = intent.getStringExtra("Farmacia").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Bazar") -> rubro.text = intent.getStringExtra("Bazar").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Ropa") -> rubro.text = intent.getStringExtra("Ropa").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Deportes") -> rubro.text = intent.getStringExtra("Deportes").toString() ?: "Vendedor no  encontrado"
            intent.hasExtra("Ofertas") -> rubro.text = intent.getStringExtra("Ofertas").toString() ?: "Vendedor no  encontrado"
        }
            when (rubro.text){
                "Smartphones" -> vendedor.text = "Claro"
                "Electrodomesticos" -> vendedor.text = "Megatone"
                "Super" -> vendedor.text = "Supermercado Becerra"
                "Ferreteria" -> vendedor.text = "Riherco"
                "Farmacia" -> vendedor.text = "Farmacia Independencia"
                "Bazar" -> vendedor.text = "Candela"
                "Ropa" -> vendedor.text = "Soul"
                "Deportes" -> vendedor.text = "Centro Sports"
                "Ofertas" -> vendedor.text = "Ofertas"
            }*/

        //llenado de precio
        val precio = findViewById<TextView>(R.id.precio_prod)
        val precioIntent = intent.getStringExtra("Precio").toString()
        precio.text = precioIntent

        //llenado de envio
        val envio = findViewById<TextView>(R.id.precioEnvio_prod)
        val envioIntent = intent.getStringExtra("Envio").toString()
        envio.text = envioIntent

        //llenado de imageview
        val imagen = findViewById<ImageView>(R.id.imagen_prod)
        imagen.setImageResource(R.mipmap.ic_launcher_round)
        Glide.with(this).load(intent.getStringExtra("Imagen"))
            .placeholder(R.drawable.mpsdk_grey_review_product_placeholder)
            .error(R.drawable.mpsdk_review_product_placeholder)
            .into(imagen)

        //llenado url img
        val urlprod = findViewById<TextView>(R.id.urlprod)
        urlprod.text = intent.getStringExtra("Imagen").toString()

        //llenado urllogo
        val urllogo = findViewById<TextView>(R.id.urllogo)
        urllogo.text = intent.getStringExtra("ImagenLogo")

        //lanzador perfil activity
        findViewById<ImageButton>(R.id.perfilbtn).setOnClickListener{ startActivity(Intent(this, PerfilActivity::class.java)) }

        //lanzador Carrito Activity
        findViewById<ImageButton>(R.id.carritoNav).setOnClickListener { startActivity(Intent(this, CarritoActivity::class.java)) }

        val prefs:SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        val prefsOk = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE)

        prefs.putString("Art0", descripcionProd.text.toString())
        prefs.putString("PrecioArt0", findViewById<TextView>(R.id.precio_prod).text.toString())

        //lanzador carrito activity
        findViewById<Button>(R.id.agregarCarritobtn_prodActivity).setOnClickListener {
            /*//val user = FirebaseAuth.getInstance().currentUser
            val user = "cucu_2009@live.com.ar"
            addProductoACarrrito(prefsOk.getString("pais","").toString(), prefsOk.getString("provincia","").toString(),prefsOk.getString("localidad","").toString(),
                user.toString(),vendedor.text.toString(),descripcionProd.text.toString())*/

            val i = Intent(this, CarritoActivity::class.java)
            i.putExtra("NuevoArt", "NuevoArt")
            i.putExtra("Envio", envio.text.toString())
            i.putExtra("Precio", findViewById<TextView>(R.id.precio_prod).text.toString())
            i.putExtra("Descripcion", descripcionProd.text.toString())
            i.putExtra("Imagen", urlprod.text.toString())

            when {
                prefsOk.contains("Art0") -> prefs.putString("Art1", descrpcionIntent)
                prefsOk.contains("PrecioArt0") -> prefs.putString("PrecioArt1", precio.text.toString())
                prefsOk.contains("Art1") -> prefs.putString("Art2", descripcionProd.text.toString())
                prefsOk.contains("PrecioArt1") -> prefs.putString("PrecioArt2", findViewById<TextView>(R.id.precio_prod).text.toString())
                prefsOk.contains("Art2") -> prefs.putString("Art3", descripcionProd.text.toString())
                prefsOk.contains("PrecioArt2") -> prefs.putString("PrecioArt3", findViewById<TextView>(R.id.precio_prod).text.toString())
                prefsOk.contains("Art3") -> prefs.putString("Art4", descripcionProd.text.toString())
                prefsOk.contains("PrecioArt3") -> prefs.putString("PrecioArt4", findViewById<TextView>(R.id.precio_prod).text.toString())
                prefsOk.contains("Art4") -> prefs.putString("Art5", descripcionProd.text.toString())
                prefsOk.contains("PrecioArt4") -> prefs.putString("PrecioArt5", findViewById<TextView>(R.id.precio_prod).text.toString())
                prefsOk.contains("Art5") -> Toast.makeText(this, "Carrito lleno", Toast.LENGTH_SHORT).show()
            }
            startActivity(i)
        }

        //lanzador perfil vendedor activity
        findViewById<TextView>(R.id.vendedorLink).setOnClickListener{
            if (vendedorLink.text == "No encontrado") { Toast.makeText(this, "No se pudo encontrar el vendedor", Toast.LENGTH_SHORT).show()}
            else {
                val i = Intent(this, PerfilVendedorActivity::class.java)
/*            when {
                intent.hasExtra("Smartphones") -> i.putExtra("Smartphones","Smartphones")
                intent.hasExtra("Electrodomesticos") -> i.putExtra("Electrodomesticos", "Electrodomesticos")
                intent.hasExtra("Super") -> i.putExtra("Super", "Super")
                intent.hasExtra("Ferreteria") -> i.putExtra("Ferreteria", "Ferreteria")
                intent.hasExtra("Farmacia") -> i.putExtra("Farmacia", "Farmacia")
                intent.hasExtra("Bazar") -> i.putExtra("Bazar", "Bazar")
                intent.hasExtra("Ropa") -> i.putExtra("Ropa", "Ropa")
                intent.hasExtra("Deportes") -> i.putExtra("Deportes", "Deportes")
                else -> i.putExtra("Ofertas", "Ofertas")
            }*/
                    .putExtra("Envio", envio.text.toString())
                    .putExtra("Nombre", vendedor.text.toString())
                    .putExtra("Ubicacion", intent.getStringExtra("Ubicacion").toString())
                    .putExtra("${rubro.text}", rubro.text.toString())
                    .putExtra("Imagen", urllogo.text)

                startActivity(i)
            }
        }

        //lanzador comprar activity
        findViewById<Button>(R.id.comprarbtn).setOnClickListener {
            startActivity(Intent(this, ComprarActivity::class.java)
                .putExtra("Envio", envio.text.toString())
                .putExtra("Precio", findViewById<TextView>(R.id.precio_prod).text.toString())
                .putExtra("Descripcion", descripcionProd.text.toString())
                .putExtra("Imagen", urlprod.text.toString())
            )
        }

    }

/*
    fun getProductoParaCarrito(pais: String, provincia: String, localidad: String, usuario: String, tienda: String, productoId: String): Producto {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val mutableData = MutableLiveData<MutableList<Producto>>()

        FirebaseFirestore.getInstance()
            .document("/pais/$pais/provincia/$provincia/localidad/$localidad/tiendas/$tienda/productos/$productoId")
            .get().addOnSuccessListener { producto ->

                val descripcion: String = producto.getString("descripcion").toString()
                val precio: String = producto.getString("precio").toString()
                val imagen: String = producto.getString("imagen").toString()
                val stock: String = producto.getString("stock").toString()
                val rubro: String = producto.getString("rubro").toString()
                val producto = Producto(descripcion, stock, precio, imagen)

            }
        return getProductoParaCarrito()
    }
*/

    fun addProductoACarrrito(pais: String, provincia: String, localidad: String, usuario: String, tienda: String, productoId: String) {
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val mutableData = MutableLiveData<MutableList<Producto>>()

        FirebaseFirestore.getInstance()
            .collection("/pais/$pais/provincias/$provincia/localidades/$localidad/usuarios/$usuario/carrito").add(

                FirebaseFirestore.getInstance()
                    .document("/pais/$pais/provincias/$provincia/localidades/$localidad/tiendas/$tienda/productos/$productoId").get().addOnSuccessListener { producto ->
                        //val listData: MutableList<Producto> = mutableListOf<Producto>()

                        /*println("Producto: ${productos.id}")
                        println("Producto: ${productos.data}")*/

                        //val listData: MutableList<Producto> = mutableListOf<Producto>()
                        val descripcion: String = producto.getString("descripcion").toString()
                        val precio: String = producto.getString("precio").toString()
                        val imagen: String = producto.getString("imagen").toString()
                        val stock: String = producto.getString("stock").toString()
                        val rubro: String = producto.getString("rubro").toString()
                        val producto = Producto(descripcion, stock, precio, imagen)

                        /*println("descripcion: " + producto.descripcion)
                        listData.add(producto)
                        mutableData.value = listData

                        mutableData.value = listData
                        println("mutabledata: ${mutableData.value}")*/
                    }
            )
    }
}