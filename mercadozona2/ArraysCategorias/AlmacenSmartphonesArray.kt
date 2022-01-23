package com.example.mercadozona2.ArraysCategorias

import java.util.*

class AlmacenSmartphonesArray : AlmacenElementos {

    private val elementos: MutableList<String?>
    private val precioList: MutableList<String?>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        precioList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Samsung Galaxy pocket")
        precioList.add("2000")
        imagenes.add("https://static.turbosquid.com/Preview/2014/10/13__12_29_00/1.jpge1534f40-a8c6-4788-b4a4-7029f09ea04aLarge.jpg")
        elementos.add("Xiaomi note 9S")
        precioList.add("40000")
        imagenes.add("https://lh3.googleusercontent.com/proxy/br0o4p1lDBTCjdaJqvNCbPsaseBVKMPu4ZK359vAuS43dGY3i7ltLTWPfcbIIvL_0yTZcGjai2nNsj7rKucNqrsBN7vCZGWJO_XYbwlPnpMCUcdO1KXHXoEOpGJ36zJIwOG41rmWy_7dsLhiMEjNfNb2oEG3zg")
        elementos.add("Iphone x")
        precioList.add("200000")
        imagenes.add("https://ar.celulares.com/fotos/apple-iphone-x-59552-g.jpg")
        elementos.add("LG V10")
        precioList.add("10000")
        imagenes.add("https://m.media-amazon.com/images/I/71Mo0Ym4cKL._AC_SX522_.jpg")
        elementos.add("Pocophone f1")
        precioList.add("30000")
        imagenes.add("https://www.notebookcheck.org/fileadmin/Notebooks/News/_nc3/download8766.jpg")
        elementos.add("Pixel XL")
        precioList.add("39000")
        imagenes.add("https://celularess.com/wp-content/uploads/2019/12/Google-Pixel-XL-600x600.jpg")
        elementos.add("Blu Vivo XL")
        precioList.add("15000")
        imagenes.add("https://www.tiendavargas.com/images/thumbs/0002715_celular-blu-vivo-xl-4-v0350ww_510.jpeg")
        elementos.add("Blackberry")
        precioList.add("8000")
        imagenes.add("https://i.blogs.es/c52406/bb-curve-3g/450_1000.jpg")
    }

    override fun listaElementos(cantidad: Int): List<String?>? {
        return elementos
    }

    override fun listaPrecios(cantidad: Int): List<String?>? {
        return precioList
    }

    override fun imagenes(cantidad: Int): List<String?> {
        return imagenes
    }

}