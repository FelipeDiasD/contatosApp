package com.example.contatosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView


//Classe que gerencia a RecyclerView (lista)
class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

//Variável para armazenar a lista que eu vou receber
    private val list : MutableList <Contact> = mutableListOf()

//Membros da classe Adapter

//Função que cria cada item visual na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
    //Estrutura que diz de fato quem é o arquivo XML que vai desenhar o item na tela
       val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent,false)
       return ContactAdapterViewHolder(view)
    }
//Função que varre cada item da lista e preenche as informações na tela (Popula itens no RecyclerView)
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }
//Função que deseja saber a auantidade de itens que tem na lista
    override fun getItemCount(): Int {
    return list.size
}
    //função que passa a acessa a lista da classe externa para o adpter
    fun updateList(List: List<Contact>) {
        this.list.clear() //Limpa
        this.list.addAll(list) //Popula com a lista
        notifyDataSetChanged() //Notifica o adpter falando que a lista foi modificada, fazendo ele ser rodado novamente
    }
    //Classe que gerencia cada item da recycleView
    class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvTelefone: TextView = itemView.findViewById(R.id.tv_telefone)
        private val ivFoto: ImageView = itemView.findViewById(R.id.iv_Photograph)

        //Função que vai fazer a declaração de cada item do nosso contato
          fun bind(contact: Contact){

            tvName.text = contact.name
            tvTelefone.text = contact.telefone


           }
    }
}