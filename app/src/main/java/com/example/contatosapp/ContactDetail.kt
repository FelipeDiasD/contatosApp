package com.example.contatosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContactDetail : AppCompatActivity() {

    private var contact: Contact? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        getExtras()
        initToolbar()
        bindViews()
    }


//Método para iniciar uma toolbar na nossa activity detail
private fun initToolbar(){

    val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)
    //botão de voltar na toolbar
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
}
//Método para recuperar os dados na activity detail, via extras
    private fun getExtras(){

    contact = intent.getParcelableExtra(EXTRA_CONTACT)

    }

//Setando esses dados recuperados na tela

private fun bindViews(){
    findViewById<TextView>(R.id.tv_name).text = contact?.name
    findViewById<TextView>(R.id.tv_telefone).text = contact?.telefone
}

    //criando chave identificadora do objeto

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }
}