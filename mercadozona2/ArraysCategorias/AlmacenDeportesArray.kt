package com.example.mercadozona2.ArraysCategorias

class AlmacenDeportesArray: AlmacenElementos {

    private val elementos: MutableList<String?>
    private val preciosList: MutableList<String>
    private val imagenes: MutableList<String>


    init {
        elementos = ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Futbol 5 Nike")
        preciosList.add("5300")
        imagenes.add("https://www.dexter.com.ar/on/demandware.static/-/Sites-dabra-catalog/default/dwf5c2de09/products/NI_SC3974-101/NI_SC3974-101-1.JPG")
        elementos.add("Botines Adidas")
        preciosList.add("14000")
        imagenes.add("https://assets.adidas.com/images/w_600,f_auto,q_auto/0508f36a10a247878914ab43010871a2_9366/Botines_X_19.1_Terreno_Suave_Blanco_EG7143_01_standard.jpg")
        elementos.add("Raqueta Wilson")
        preciosList.add("11000")
        imagenes.add("https://wilsonstore.com.ar/media/catalog/product/cache/97001a7609811bc0c28380f578d7c7df/c/2/c268eb2dc74eee8c34af29c42cca42a7e304d4d2_wrt74191u_pro_staff_97lcv_bl_wh_side.jpg")
        elementos.add("Short Salomon")
        preciosList.add("3500")
        imagenes.add("https://www.salomonstore.com.ar/media/catalog/product/cache/fac7280e0d0ff2a98b5e31fe1a2d4a3a/1/6/16786_2.jpg")
        elementos.add("Bolsa box")
        preciosList.add("3000")
        imagenes.add("https://www.deportesmd.com.ar/sistema/uploads/699/articulos/bolsa-box-everlast-powercore-nevatear-heavy-bag-de-117-cm.jpg")
        elementos.add("Palo jockey")
        preciosList.add("15000")
        imagenes.add("https://deportesonce.com.ar/wp-content/uploads/virtuemart/product/PALO-DE-HOCKEY-NASSAU-HERO-BLANCO-26-600x600.jpg")
        elementos.add("Pelotas tenis Topper")
        preciosList.add("900")
        imagenes.add("https://redsport.vteximg.com.br/arquivos/ids/253536-1000-1000/GA020144273.jpg?v=636075840570400000")
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