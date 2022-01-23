package com.example.mercadozona2.ArraysCategorias

class AlmacenRopaArray: AlmacenElementos {

    private val elementos: MutableList<String?>
    private val preciosList: MutableList<String>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Campera parka hombre")
        preciosList.add("9900")
        imagenes.add("https://d368r8jqz0fwvm.cloudfront.net/29393-product_lg/parka-de-hombre-nolan.jpg")
        elementos.add("Campera parka mujer")
        preciosList.add("9900")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_713128-MLA45868471679_052021-W.jpg")
        elementos.add("Jean Levis hombre")
        preciosList.add("2300")
        imagenes.add("https://statics.glamit.com.ar/skin/frontend/default/levis/images/carrusel-jeans/taper-hombre1.png")
        elementos.add("Babucha")
        preciosList.add("1500")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_693376-MLA45687370416_042021-O.jpg")
        elementos.add("Short jean")
        preciosList.add("1100")
        imagenes.add("https://www.digitalsport.com.ar/files/products/5eab2c27f1caf-502035-500x500.jpg")
        elementos.add("Gorra Boss")
        preciosList.add("2300")
        imagenes.add("https://m.media-amazon.com/images/I/617JN0bM34L._AC_UX342_.jpg")
        elementos.add("Remera Polo")
        preciosList.add("2000")
        imagenes.add("https://megasports.vteximg.com.br/arquivos/ids/204183-1000-1000/13700402001_0.jpg?v=637626545270370000")
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