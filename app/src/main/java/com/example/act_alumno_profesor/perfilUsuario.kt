package com.example.act_alumno_profesor

import android.os.Bundle

class perfilUsuario {

    var nombre:String

    var apellido:String

    var perfil:String


    constructor(nombre: String, apellido: String, perfil: String) {
        this.nombre = nombre
        this.apellido = apellido
        this.perfil = perfil
    }

    constructor(bundle: Bundle) {
        this.nombre = bundle.getString("nombre")!!
        this.apellido = bundle.getString("apellido")!!
        this.perfil = bundle.getString("perfil")!!
    }


    fun getBundle(): Bundle? {
        var bundle = Bundle()

        bundle.putString("nombre", this.nombre)
        bundle.putString("apellido", this.apellido)
        bundle.putString("perfil", this.perfil)
        return bundle
    }
}