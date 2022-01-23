package com.example.mercadozona2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercadozona2.Adapters.AdaptadorTiendas.ViewHolder
import com.example.mercadozona2.R

class AdaptadorTiendas(private val context: Context, private val nombres:List<String>, private  val ubicaciones:List<String>, private val rubros:List<String>, private  val imagenes: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    private val inflador = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflador.inflate(R.layout.elemento_tienda, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = nombres[position]
        holder.ubicacion.text = ubicaciones[position]
        holder.rubro.text = rubros[position]

        holder.seguirbtn.setOnClickListener {
            holder.seguirbtn.visibility = View.GONE
            holder.siguiendobtn.visibility = View.VISIBLE
        }

        holder.siguiendobtn.setOnClickListener {
            holder.seguirbtn.visibility = View.VISIBLE
            holder.siguiendobtn.visibility = View.GONE
        }

        val imagenp = imagenes[position]
        Glide.with(context)
            .load(imagenp)
            .error(R.drawable.superr)
            .placeholder(R.drawable.superr)
            .into(holder.imagen)

        holder.url.text = imagenes[position]
    }

    override fun getItemCount(): Int {
        return nombres.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var nombre = itemView.findViewById<TextView>(R.id.nombre_tienda)
        var ubicacion = itemView.findViewById<TextView>(R.id.ubicacion_tienda)
        var rubro = itemView.findViewById<TextView>(R.id.rubro)

        val imagen = itemView.findViewById<ImageView>(R.id.imagen_info)
        val url = itemView.findViewById<TextView>(R.id.urlimg)

        val seguirbtn = itemView.findViewById<Button>(R.id.seguirbtn)
        val siguiendobtn = itemView.findViewById<Button>(R.id.siguiendobtn)

    }
}