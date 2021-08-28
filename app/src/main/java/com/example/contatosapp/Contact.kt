package com.example.contatosapp
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var name: String,
    var telefone: String,
    var image: String
    ) : Parcelable

//Parcelize e parcelable tornam essa classe apta para transferir dados entre telas
//Por exemplo quando chamamos a tela detail, as inforações do objeto contact precisam ser transferidas para lá