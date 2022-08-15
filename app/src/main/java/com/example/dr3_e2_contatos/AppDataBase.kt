package com.example.dr3_e2_contatos

import androidx.room.Database
import androidx.room.RoomDatabase


@Database ( entities = arrayOf(Contato::class), version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun obterContatoDAO(): ContatoDAO
}