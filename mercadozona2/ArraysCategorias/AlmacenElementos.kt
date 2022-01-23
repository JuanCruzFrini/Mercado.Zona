package com.example.mercadozona2.ArraysCategorias

interface AlmacenElementos {
    fun listaElementos(cantidad: Int): List<String?>?
    fun listaPrecios(cantidad: Int): List<String?>?
    fun imagenes(cantidad: Int):  List<String?>
}