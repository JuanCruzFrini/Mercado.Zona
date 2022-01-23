package com.example.mercadozona2.ArraysCategorias

class AlmacenFerreteriaArray : AlmacenElementos {

    private val elementos: MutableList<String?>
    private val preciosList: MutableList<String?>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Amoladora Black & Decker")
        preciosList.add("6000")
        imagenes.add("https://d3ugyf2ht6aenh.cloudfront.net/stores/649/588/products/g650_11-d1e3aa2e7a4326735615645237601325-1024-1024.jpg")
        elementos.add("Motoguadaña Echo 4300")
        preciosList.add("80000")
        imagenes.add("https://laquintasi.com/wp-content/uploads/2016/04/97.motoguadana-echo-srm-4300.jpg")
        elementos.add("Llave Bhaco")
        preciosList.add("300")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_788896-MLA31042011888_062019-O.jpg")
        elementos.add("Fresadora DeWalt")
        preciosList.add("5400")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_754239-MLA31020817133_062019-O.jpg")
        elementos.add("Sierra circular Makita")
        preciosList.add("12500")
        imagenes.add("https://www.martinezescalada.com.ar/4531-large_default/sierra-circular-hs7010-makita.jpg")
        elementos.add("Rollo tanza motoguadaña 50mts")
        preciosList.add("1000")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_774001-MLA42284006132_062020-V.jpg")
        elementos.add("Motosierra Funkamal")
        preciosList.add("4999")
        imagenes.add("https://sc04.alicdn.com/kf/HTB1wWkTaEvrK1RjSspcq6zzSXXa5.jpg")
    }

    override fun listaElementos(cantidad: Int): List<String?>? {
        return elementos
    }

    override fun listaPrecios(cantidad: Int): List<String?>? {
        return preciosList
    }

    override fun imagenes(cantidad: Int): List<String?> {
        return imagenes
    }

}