package com.example.mercadozona2

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class CategoriasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categorias)

        //lanzamos Recycler smartphones
        findViewById<LinearLayout>(R.id.celubtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Smartphones", "Smartphones"))
        }

        //lanzamos Recycler electrodomesticos
        findViewById<LinearLayout>(R.id.electrosbtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Electrodomesticos", "Electrodomesticos"))
        }

        //lanzamos Recycler super
        findViewById<LinearLayout>(R.id.superbtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Super", "Super"))
        }

        //lanzamos Recycler ferreteria
        findViewById<LinearLayout>(R.id.ferreteriabtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Ferreteria", "Ferreteria"))
        }

        //lanzamos recycler Farmacia
        findViewById<LinearLayout>(R.id.farmaciabtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Farmacia", "Farmacia"))
        }

        //lanzamos recycler bazar
        findViewById<LinearLayout>(R.id.bazarbtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Bazar", "Bazar"))
        }

        //lanzamos recycler ropa
        findViewById<LinearLayout>(R.id.ropabtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Ropa", "Ropa"))
        }

        //lanzamos recycler deportes
        findViewById<LinearLayout>(R.id.deportesbtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Deportes", "Deportes"))
        }

        //lanzamos recycler ofertas
        findViewById<LinearLayout>(R.id.ofertasbtn).setOnClickListener {
            startActivity(Intent(this, Lista::class.java)
                .putExtra("Ofertas", "Ofertas"))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim_estatica, R.anim.entrada_abajo)
    }
}