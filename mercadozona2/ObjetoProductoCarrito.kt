package com.example.mercadozona2

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class ObjetoProductoCarrito(descripcion:String, precio:String, envio:String, context: Context?) : AppCompatActivity() {

    ///override fun onDraw(){}
    @RequiresApi(Build.VERSION_CODES.Q)
    fun nuevoArt(): View? {
        val linear = LinearLayout(this)
        setContentView(R.layout.elemento_lista)
        return layoutInflater.createView(this, "carrito", null , null)
    }

}