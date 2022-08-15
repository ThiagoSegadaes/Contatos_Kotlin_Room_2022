package com.example.dr3_e2_contatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

class Contato (

    @PrimaryKey (autoGenerate = true) val id : Int? = null,
    val nome : String,
    val email : String,
    val fone : String,

    )