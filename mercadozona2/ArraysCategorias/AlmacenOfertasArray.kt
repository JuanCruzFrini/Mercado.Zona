package com.example.mercadozona2.ArraysCategorias

class AlmacenOfertasArray: AlmacenElementos {

    private val elementos: MutableList<String?>
    private val preciosList: MutableList<String>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Fresadora DeWalt")
        preciosList.add("5400")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_754239-MLA31020817133_062019-O.jpg")
        elementos.add("Vaso plastico")
        preciosList.add("100")
        imagenes.add("https://www.impobazar.com.ar/wp-content/uploads/2020/05/13270005_0.jpg")
        elementos.add("Maceta de interior")
        preciosList.add("3000")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_975254-MLM47365644576_092021-O.jpg")
        elementos.add("Bolsa box")
        preciosList.add("3000")
        imagenes.add("https://www.deportesmd.com.ar/sistema/uploads/699/articulos/bolsa-box-everlast-powercore-nevatear-heavy-bag-de-117-cm.jpg")
        elementos.add("Gorra Boss")
        preciosList.add("2300")
        imagenes.add("https://m.media-amazon.com/images/I/617JN0bM34L._AC_UX342_.jpg")
        elementos.add("Promo viña balbo + pritty")
        preciosList.add("350")
        imagenes.add("https://indrinks.com.ar/wp-content/uploads/2020/04/Vi%C3%B1a-de-Balbo-2.25L-Pritty-1.5lt.jpg")
        elementos.add("Promo Fernet + coca")
        preciosList.add("1000")
        imagenes.add("https://vinotecalavia.com/4852-large_default/fernet-branca-750cc-1-coca-cola-225lt.jpg")
    }

    override fun listaElementos(cantidad: Int): List<String?>? {
        return elementos
    }

    override fun listaPrecios(cantidad: Int): List<String?>? {
        return preciosList
    }

    override fun imagenes(cantidad: Int):List<String?>{
        return imagenes
    }
}