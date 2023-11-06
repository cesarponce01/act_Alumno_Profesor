package com.example.act_alumno_profesor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import com.example.act_alumno_profesor.actMostrarDatos
import com.example.act_alumno_profesor.perfilUsuario

class MainActivity : AppCompatActivity() {

    lateinit var etNombre:EditText
    lateinit var etApellido:EditText
    lateinit var nombre:String
    lateinit var apellido:String
    lateinit var perfil:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre=findViewById(R.id.etNombre)
        etApellido=findViewById(R.id.etApellido)
    }

    fun onAlta(view:View){
        nombre=etNombre.text.toString()
        apellido=etApellido.text.toString()

        var perfilUser=perfilUsuario(nombre, apellido, perfil)
        var miIntent=Intent(this,actMostrarDatos::class.java)
        miIntent.putExtra("claseUsuario", perfilUser.getBundle())
        startActivity(miIntent)
    }
    fun setPerfil(view:View){

        val Profesor=R.id.rbtnProfesor
        val Alumno=R.id.rbtnAlumno

        if (view is RadioButton){
            val seleccion=view.isChecked

            when (view.getId()){
                Profesor->
                    if (seleccion){
                        perfil=Profesor.toString()
                    }
                Alumno ->{
                    if (seleccion){
                        perfil=Alumno.toString()
                    }
                }
            }
        }

    }
}