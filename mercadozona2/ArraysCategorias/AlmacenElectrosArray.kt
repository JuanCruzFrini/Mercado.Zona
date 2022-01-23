package com.example.mercadozona2.ArraysCategorias

import java.util.*

class AlmacenElectrosArray : AlmacenElementos {

    private val elementos: MutableList<String?>
    private val precioList: MutableList<String?>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        precioList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Heladera Samsung Froster 2000")
        precioList.add("78000")
        imagenes.add("https://images.samsung.com/is/image/samsung/ar-heladera-rt32k5930slb3-rt32k5930sl-b3-frontsilver-83259032?\$720_576_PNG\$")
        elementos.add("Lavarropas 7kg Patrick")
        precioList.add("38990")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_819723-MLA46332642930_062021-O.jpg")
        elementos.add("Secarropas koh-i-noor")
        precioList.add("32490.99")
        imagenes.add("https://www.elitehogar.com.ar/wp-content/uploads/2019/12/secarropas_clasico.jpg")
        elementos.add("Microondas BGH b22-10")
        precioList.add("29990")
        imagenes.add("https://images.fravega.com/f1000/a3500b86977929efad3f9d059f73c435.jpg")
        elementos.add("Lavarropas Whirpool w20-21")
        precioList.add("53999.99")
        imagenes.add("https://whirlpoolarg.vteximg.com.br/arquivos/ids/161298-1000-1000/WLF75AB-05.jpg?v=637405367135570000")
        elementos.add("Horno electrico fukijama")
        precioList.add("19000")
        imagenes.add("https://www.necxus.com.ar/products_image/10879/1000x1000_1.jpg")
        elementos.add("Frigobar 20lts")
        precioList.add("15000")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_858544-MLA31581139408_072019-O.jpg")
        elementos.add("Cocina industrial Repijuda")
        precioList.add("800000.00")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_882236-MLA40913092842_022020-O.jpg")
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