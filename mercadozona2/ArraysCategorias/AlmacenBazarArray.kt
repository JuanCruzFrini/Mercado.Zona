package com.example.mercadozona2.ArraysCategorias

class AlmacenBazarArray: AlmacenElementos {

    private val elementos: MutableList<String?>
    private val preciosList: MutableList<String>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Vaso plastico")
        preciosList.add("100")
        imagenes.add("https://www.impobazar.com.ar/wp-content/uploads/2020/05/13270005_0.jpg")
        elementos.add("Cuchillo parrillero")
        preciosList.add("700")
        imagenes.add("https://lavacatuerta.gestionbos.com/archivos/BOS1/productos/6153/1_TRA022-cuchillo.jpg")
        elementos.add("Tabla madera")
        preciosList.add("450")
        imagenes.add("https://i.ytimg.com/vi/wux6EM1_p4w/maxresdefault.jpg")
        elementos.add("Vaso vidrio")
        preciosList.add("150")
        imagenes.add("https://industriaslitoral.com.ar/wp-content/uploads/sites/25/2018/10/vasotucuman.jpg")
        elementos.add("Sillon Brent")
        preciosList.add("45000")
        imagenes.add("https://silloneseuropa.com.ar/wp-content/uploads/2020/05/brent1.jpg")
        elementos.add("Maceta de interior")
        preciosList.add("3000")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_975254-MLM47365644576_092021-O.jpg")
        elementos.add("Lampara Vintage")
        preciosList.add("4200")
        imagenes.add("https://d2r9epyceweg5n.cloudfront.net/stores/001/162/321/products/img_97981-699cee062d4674087015874744495588-1024-1024.jpg")
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