package com.example.act_alumno_profesor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.act_alumno_profesor.R
import com.example.act_alumno_profesor.perfilUsuario


class actMostrarDatos : AppCompatActivity() {

    lateinit var txtNombre: TextView
    lateinit var txtApellido: TextView
    lateinit var txtPerfil: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_mostrar_datos)

        txtNombre=findViewById(R.id.txtNombre)
        txtApellido=findViewById(R.id.txtApellido)
        txtPerfil=findViewById(R.id.txtPerfil)

        var bundlePerfil=intent.getBundleExtra("perfilUsuario")
        var perfil=perfilUsuario(bundlePerfil!!)
        txtNombre.text =perfil.nombre
        txtApellido.text=perfil.apellido
        txtPerfil.text=perfil.perfil
    }
}