package com.example.act_alumno_profesor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    lateinit var etNombre:EditText
    lateinit var etApellido:EditText
    lateinit var nombre:String
    lateinit var apellido:String
    lateinit var perfil:String
    lateinit var Profesor:RadioButton
    lateinit var Alumno:RadioButton

    companion object{
        const val REQUEST_CODE_ACTMOSTRARDATOS=1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre=findViewById(R.id.etNombre)
        etApellido=findViewById(R.id.etApellido)
        Profesor=findViewById(R.id.rbtnProfesor)
        Alumno=findViewById(R.id.rbtnAlumno)

    }


    fun onAlta(view:View){
        nombre=etNombre.text.toString()
        apellido=etApellido.text.toString()

        val perfilUser=perfilUsuario(nombre, apellido, perfil)
        val miIntent=Intent(this,actMostrarDatos::class.java)
        miIntent.putExtra("claseUsuario", perfilUser.getBundle())

        startActivityForResult(miIntent, REQUEST_CODE_ACTMOSTRARDATOS)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==REQUEST_CODE_ACTMOSTRARDATOS){
            etNombre.text.clear()
            etApellido.text.clear()
            Profesor.isChecked=false
            Alumno.isChecked=false
            etNombre.requestFocus()
        }
    }

    fun setPerfil(view:View){
        if (view is RadioButton){
            val seleccion=view.isChecked

            when (view.getId()){
                Profesor.id->
                    if (seleccion){
                        perfil=Profesor.text.toString()
                    }
                Alumno.id ->{
                    if (seleccion){
                        perfil=Alumno.text.toString()
                    }
                }
            }
        }

    }

}