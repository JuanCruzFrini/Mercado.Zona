package com.example.mercadozona2.ArraysCategorias

class AlmacenFarmaciaArray: AlmacenElementos {

    private val elementos: MutableList<String>
    private val preciosList: MutableList<String>
    private val imagenes: MutableList<String>

    init {
        elementos =ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Actron 600")
        preciosList.add("300")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_777140-MLU47249258593_082021-O.jpg")
        elementos.add("Actron 400")
        preciosList.add("250")
        imagenes.add("https://www.actron.com.ar/sites/g/files/vrxlpx19316/files/2021-03/rap_0.png?imwidth=5000")
        elementos.add("Tintura fantasia Otowil")
        preciosList.add("800")
        imagenes.add("https://hercostiendaonline.com/wp-content/uploads/2020/07/tintura-fantasia-cielo-color-otowil-gris-smoke-lefemme-D_NQ_NP_795132-MLA41095856113_032020-F.jpg")
        elementos.add("Cepillo dental Gum")
        preciosList.add("400")
        imagenes.add("https://www.sunstargum.com/content/dam/sunstar-europe/gum/pack-shots/toothbrush/classic/P409_GUM_classic_toothbrush_blue.png/_jcr_content/renditions/cq5dam.thumbnail.360.600.png")
        elementos.add("Pasta dental Colgate")
        preciosList.add("200")
        imagenes.add("https://pedidosfarma.vteximg.com.br/arquivos/ids/180953-400-400/Colgate-Maxima-Proteccion-Con-Calcio-Crema-Dental-180g.jpg?v=637485086668130000")
        elementos.add("Jabon Nivea")
        preciosList.add("80")
        imagenes.add("https://www.farmacialeloir.com.ar/img/articulos/2020/10/nivea_jabon_cremoso_1_imagen2.jpg")
        elementos.add("Pañales Babysec")
        preciosList.add("950")
        imagenes.add("https://farmacityar.vteximg.com.br/arquivos/ids/197571-1000-1000/215709_panales-babysec-premium-flexi-protect_imagen-1.jpg?v=637236833399170000")
        elementos.add("Crema hidratante dermaglos")
        preciosList.add("400")
        imagenes.add("https://www.vassallo.com.ar/9171-large_default/dermaglos-ultra-f-noche-30-f3.jpg")
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