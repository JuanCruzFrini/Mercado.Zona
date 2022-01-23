package com.example.mercadozona2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercadozona2.Producto
import com.example.mercadozona2.R
import kotlinx.android.synthetic.main.elemento_lista.view.descripcion_main
import kotlinx.android.synthetic.main.elemento_lista.view.imagen_info
import kotlinx.android.synthetic.main.elemento_lista.view.precio_rv
import kotlinx.android.synthetic.main.elemento_lista_desde_empresa.view.*

class MiAdaptadorFirebase(private val context: Context):RecyclerView.Adapter<MiAdaptadorFirebase.ViewHolder>() {

    private var dataList = mutableListOf<Producto>()

    fun setListData(data:MutableList<Producto>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.elemento_lista_desde_empresa, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto: Producto = dataList[position]
        holder.bindView(producto)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindView(producto: Producto){
            itemView.descripcion_main.text = producto.descripcion
            itemView.precio_rv.text = producto.precio
            itemView.stock.text = producto.stock
            itemView.urlimg.text = producto.imagenes
            Glide.with(context)
                .load(producto.imagenes)
                .placeholder(R.drawable.mpsdk_grey_review_product_placeholder)
                .error(R.drawable.mpsdk_review_product_placeholder)
                .into(itemView.imagen_info)
        }
    }
}