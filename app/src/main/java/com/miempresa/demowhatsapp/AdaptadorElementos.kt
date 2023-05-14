package com.miempresa.demowhatsapp

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorElementos(val listaElementos:ArrayList<Elementos>): RecyclerView.Adapter<AdaptadorElementos.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
        val fHora = itemView.findViewById<TextView>(R.id.elemento_hora)
        val fDescripcion = itemView.findViewById<TextView>(R.id.descripcion)
        val fNotificacion = itemView.findViewById<TextView>(R.id.elemento_notificacion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_elementoslista, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.fTexto.text = listaElementos[position].texto
        holder.fImagen.setImageResource(listaElementos[position].imagen)
        holder.fHora.text = listaElementos[position].hora
        holder.fDescripcion.text = listaElementos[position].descripcion

        if (listaElementos[position].notificacion) {
            holder.fNotificacion.visibility = View.VISIBLE
            holder.fNotificacion.text = listaElementos[position].notificacionCantidad
            holder.fTexto.setTypeface(null, Typeface.BOLD)
        } else {
            holder.fHora.setTextColor(Color.GRAY)
            holder.fNotificacion.visibility = View.GONE
        }

        holder.itemView.setOnCreateContextMenuListener { contextMenu, _, _ ->
            contextMenu.setHeaderTitle("Se eligió opción " + (position + 1))
        }
    }

    override fun getItemCount(): Int {
        return listaElementos.size
    }
}
