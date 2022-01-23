package com.example.mercadozona2.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercadozona2.R

class MiAdaptador(private val context: Context, private val lista: List<String>, private val listaPrecios: List<String>, val imagenes:List<String?>): RecyclerView.Adapter<MiAdaptador.ViewHolder>(){

    private val inflador: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflador.inflate(R.layout.elemento_lista, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.articulo.setText(lista.get(position));
        holder.descrpicion.text = lista[position]
        holder.precio.text = listaPrecios[position]

        var imagenp = imagenes[position]
        var i = Glide.with(context)
            .load(imagenp)
            .error(R.drawable.logo_radar_sin_fondo)
            .placeholder(R.drawable.logo_radar_sin_fondo)
            .into(holder.imagen)
        holder.url.text = imagenp

        //animacion agregar a favoritos
        holder.favorito.setOnClickListener {
            holder.favorito.visibility = View.GONE
            holder.favoritoOC.visibility = View.VISIBLE
            //Toast.makeText(this, "Favorito added", Toast.LENGTH_SHORT).show()
        }
        holder.favoritoOC.setOnClickListener {
            holder.favorito.visibility = View.VISIBLE
            holder.favoritoOC.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var articulo: TextView = itemView.findViewById(R.id.articulo_main)
        var descrpicion: TextView = itemView.findViewById(R.id.descripcion_main)
        var precio: TextView = itemView.findViewById(R.id.precio_rv)
        var precioEnvio: TextView = itemView.findViewById(R.id.envio_mainActivity)

        var imagen: ImageView = itemView.findViewById(R.id.imagen_info)
        var url: TextView = itemView.findViewById(R.id.urlimg)

        val favorito: ImageButton = itemView.findViewById(R.id.favorito)
        val favoritoOC: ImageButton = itemView.findViewById(R.id.favoritoOC)
    }
}
