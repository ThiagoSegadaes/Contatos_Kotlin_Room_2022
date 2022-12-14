package com.example.dr3_e2_contatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.room.Room

class MainActivity : AppCompatActivity(), View.OnLongClickListener{

    private lateinit var contatoDAO: ContatoDAO



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //---------------------------------------//

        val AppDataBase = Room.databaseBuilder(
            this,
            AppDataBase::class.java,
            "contatos.db"

        ).allowMainThreadQueries().build()
        contatoDAO = AppDataBase.obterContatoDAO()

        //--------------------------------------//

        this.atualizarLista()

        //--------------------------------------//

        val btnSalvar = this.findViewById<Button>(R.id.btnSalvar)
        btnSalvar.setOnClickListener{

            val txtNome = this.findViewById<EditText>(R.id.txtNome)
            val txtEmail = this.findViewById<EditText>(R.id.txtEmail)
            val txtFone = this.findViewById<EditText>(R.id.txtFone)
            val contato = Contato(
                null,
                txtNome.text.toString(),
                txtEmail.text.toString(),
                txtFone.text.toString()
            )
            contatoDAO.inserir(contato)
            txtNome.setText(null)
            txtEmail.setText(null)
            txtFone.setText(null)
            this.atualizarLista()
        }
    }

    private fun atualizarLista() {

        val contatos = contatoDAO.listar()
        val nomes = ArrayList<String>()
        for (i in 0..contatos.size - 1) {

            nomes.add(contatos.get(i).nome)
        }
        val lstContatos = this.findViewById<ListView>(R.id.lstContatos)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes)
        lstContatos.adapter = adapter
    }

    override fun onLongClick(v: View?): Boolean {
        TODO("Not yet implemented")
    }

}

