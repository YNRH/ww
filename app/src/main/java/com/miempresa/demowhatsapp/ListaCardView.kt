package com.miempresa.demowhatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class ListaCardView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_card_view)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        // supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        lista.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        lista.layoutManager = LinearLayoutManager(this)

        val llenarLista = ArrayList<Elementos>()
        llenarLista.add(Elementos("Whitmans Chat ", R.drawable.img, "12:32 PM", true, "Ned. Yeah, I think I know...", "2"))
        llenarLista.add(Elementos("Stewart Family ", R.drawable.img_6, "11:54 AM", true, "Steve. Great, Thanks!", "110"))
        llenarLista.add(Elementos("Alice Whitman ", R.drawable.img_5, "9:44 AM", true, "Image", "8"))
        llenarLista.add(Elementos("Jack Whitman ", R.drawable.img_3, "8:58 AM", false, "Audio 0:07", "0"))
        llenarLista.add(Elementos("Lunch Group ", R.drawable.img_4, "YESTERDAY", false, "You: Sounds good!", "0"))
        llenarLista.add(Elementos("Jane Pearson ", R.drawable.img_1, "FRIDAY", false, "emoticon", "0"))

        val adapter = AdaptadorElementos(llenarLista)
        lista.adapter = adapter

        registerForContextMenu(lista)
    }
}