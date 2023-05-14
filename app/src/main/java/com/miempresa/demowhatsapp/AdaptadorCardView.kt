package com.miempresa.demowhatsapp

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCardView (val ListaElementos:ArrayList<Elementos>):
    RecyclerView.Adapter<AdaptadorCardView.ViewHolder>() {
    class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView) {
        val fTexto = itemView.findViewById<TextView>(R.id.elemento_texto)
        val fImagen = itemView.findViewById<ImageView>(R.id.elemento_imagen)
        val fHora = itemView.findViewById<TextView>(R.id.elemento_hora)
        val fDescripcion = itemView.findViewById<TextView>(R.id.descripcion)
        val fNotificacion = itemView.findViewById<TextView>(R.id.elemento_notificacion)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.elementoscardview, parent, false)
        return AdaptadorCardView.ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ListaElementos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.fTexto?.text = ListaElementos[position].texto
        holder?.fImagen?.setImageResource(ListaElementos[position].imagen)
        holder?.fHora?.text = ListaElementos[position].hora
        holder?.fDescripcion?.text = ListaElementos[position].descripcion

        if (ListaElementos[position].notificacion) {
            holder.fNotificacion.visibility = View.VISIBLE
            holder.fNotificacion.text = ListaElementos[position].notificacionCantidad
            holder.fTexto.setTypeface(null, Typeface.BOLD)
        } else {
            holder.fHora.setTextColor(Color.GRAY)
            holder.fNotificacion.visibility = View.GONE
        }

        holder.itemView.setOnCreateContextMenuListener { contextMenu, _, _ ->
            contextMenu.setHeaderTitle("Se eligió opción " + (position + 1))
        }
    }
}