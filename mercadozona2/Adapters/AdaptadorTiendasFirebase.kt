package com.example.mercadozona2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercadozona2.R
import com.example.mercadozona2.Tienda
import kotlinx.android.synthetic.main.elemento_tienda.view.*

class AdaptadorTiendasFirebase(private val context: Context): RecyclerView.Adapter<AdaptadorTiendasFirebase.ViewHolder>()  {

    private var dataList = mutableListOf<Tienda>()

    fun setListTiendasData(data:MutableList<Tienda>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.elemento_tienda, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tienda:Tienda = dataList[position]
        holder.bindView(tienda)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(tienda: Tienda){
            itemView.findViewById<TextView>(R.id.nombre_tienda).text = tienda.nombre
            itemView.findViewById<TextView>(R.id.ubicacion_tienda).text = tienda.ubicacion
            itemView.findViewById<TextView>(R.id.urlimg).text = tienda.imagen
            Glide.with(context)
                .load(tienda.imagen)
                .placeholder(R.drawable.logo_radar_sin_fondo)
                .error(R.drawable.superr)
                .into(itemView.imagen_info)
        }
    }
}