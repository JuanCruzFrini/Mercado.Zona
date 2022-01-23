package com.example.mercadozona2.ArrayTiendas

interface AlmacenTiendas {
    fun listaNombres(cantidad: Int): List<String?>
    fun listaUbicacion(cantidad: Int): List<String?>
    fun rubro(cantidad:Int):List<String?>
    fun imagenes(cantidad:Int):List<String?>
}