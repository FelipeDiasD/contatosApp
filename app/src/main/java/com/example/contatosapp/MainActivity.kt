package com.example.contatosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    //declarando/instanciando o componente recycler view
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }

    //declarando/instanciando o adapter que nós criamos
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)
        initDrawer()
        bindView()
        updateList()

    }
    //Inicialização do drawer layout
    private fun initDrawer(){

        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
//Implementação da ação de abrir e fechar o drawer layout
        val toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.abre_drawer,R.string.fecha_drawer)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState() //sincroniza o evento de toogle com drawer layout
    }


    private fun bindView() {
        //associando o adapter a nossa recyclerView
        rvList.adapter = adapter

        //Definindo o comportamento do recyclerView (estrutura)
        rvList.layoutManager = LinearLayoutManager(this)
    }
//Método apenas para demonstração de funcionamento do menu bar
    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Felipe",
                    "12981413189",
                    "img.png"
                )
            )
        )
    }
    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
//Criando a estrutura de menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
//captura a seleção de cada item de menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.itemMenu1 ->{

                showToast("Exibindo menu 1")
                return true
            }
            R.id.itemMenu2 ->{
                showToast("Exibindo menu 2")
                return true

            }
            else -> super.onOptionsItemSelected(item)


        }
    }
}
