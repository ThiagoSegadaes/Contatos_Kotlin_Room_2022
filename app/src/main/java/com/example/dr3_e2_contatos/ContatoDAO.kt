package com.example.dr3_e2_contatos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContatoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserir(contato: Contato)

    @Query("SELECT * FROM contato")
    fun listar() :Array<Contato>
}