package com.miempresa.demowhatsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.TabHost
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private fun addTab(tabName: String, layoutID: Int) {
        val spec: TabHost.TabSpec = tab_host.newTabSpec(tabName)
        spec.setContent(layoutID)
        spec.setIndicator(tabName)
        tab_host.addTab(spec)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        setSupportActionBar(findViewById(R.id.mitoolbar))
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_preferences)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tab_host.setup()
        addTab("CALLS", R.id.tab1)
        addTab("CHATS", R.id.tab2)
        addTab("CONTACTS", R.id.tab3)

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

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menucontextual, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.acceso -> {
                Toast.makeText(this, "Elegiste acceso", Toast.LENGTH_LONG).show()
            }
            R.id.contacto -> {
                Toast.makeText(this, "Elegiste contacto", Toast.LENGTH_LONG).show()
            }
            R.id.eliminar -> {
                Toast.makeText(this, "Elegiste eliminar", Toast.LENGTH_LONG).show()
            }
            R.id.etiquetar -> {
                Toast.makeText(this, "Elegiste etiquetar", Toast.LENGTH_LONG).show()
            }
            R.id.archivar -> {
                Toast.makeText(this, "Elegiste archivar", Toast.LENGTH_LONG).show()
            }
            R.id.silenciar -> {
                Toast.makeText(this, "Elegiste silenciar", Toast.LENGTH_LONG).show()
            }
            R.id.fijar -> {
                Toast.makeText(this, "Elegiste fijar", Toast.LENGTH_LONG).show()
            }
            R.id.marcar -> {
                Toast.makeText(this, "Elegiste marcar", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuprincipal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id:Int = item.itemId
        if (id == R.id.ajustes){
            val llamaractividad = Intent(applicationContext, Ajustes::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.acerca_de){
            val llamaractividad = Intent(applicationContext, AcercaDe::class.java)
            startActivity(llamaractividad)
            return true
        }
        if (id == R.id.buscar){
            Toast.makeText(this, "Elegiste Buscar", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.chat){
            Toast.makeText(this, "Elegiste Chat", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == android.R.id.home){
            layout_lateral.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_cuenta -> Toast.makeText(this, "Elegiste menu Cuenta", Toast.LENGTH_LONG).show()
            R.id.nav_chats -> {
                val llamaractividad = Intent(applicationContext, ListaCardView::class.java)
                startActivity(llamaractividad)
            }
        }
        return true
    }

}