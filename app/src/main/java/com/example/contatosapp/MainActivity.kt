package com.example.contatosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //obtendo o componente recycler view
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    //obtendo o adapter que nós criamos
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()

    }


    private fun bindView(){
        //associando o adapter a nossa recyclerView
       rvList.adapter = adapter

        //Definindo o comportamento do recyclerView (estrutura)
        rvList.layoutManager = LinearLayoutManager(this)
    }
}