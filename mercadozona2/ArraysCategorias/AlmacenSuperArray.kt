package com.example.mercadozona2.ArraysCategorias

class AlmacenSuperArray : AlmacenElementos {

    private val elementos: MutableList<String?>
    private var preciosList:  MutableList<String?>
    private val imagenes: MutableList<String>

    init {
        elementos = ArrayList()
        preciosList = ArrayList()
        imagenes = ArrayList()
        elementos.add("Yogurt la serenisima")
        preciosList.add("150")
        imagenes.add("https://www.laserenisimavaatucasa.com.ar/wp-content/uploads/2021/01/7791337603226.png")
        elementos.add("Crema la mantecola")
        preciosList.add("170")
        imagenes.add("https://img.alvearsupermercados.com.ar/Productos/Lacteos/Cremas-de-leche/sancor-62270-1.png")
        elementos.add("carne para milanga x Kg")
        preciosList.add("1000")
        imagenes.add("https://e7.pngegg.com/pngimages/944/983/png-clipart-veal-milanese-asado-beefsteak-barbecue-barbecue-barbecue-food.png")
        elementos.add("Queso rallado La Paulina sobre")
        preciosList.add("350")
        imagenes.add("https://walmartar.vteximg.com.br/arquivos/ids/866067-1000-1000/Agua-Saborizada-Naranja-Aquarius-15-Lt-2430.jpg?v=637273766034470000")
        elementos.add("Mantecol")
        preciosList.add("120")
        imagenes.add("https://http2.mlstatic.com/D_NQ_NP_762726-MLA43190637793_082020-O.jpg")
        elementos.add("Promo viña balbo + pritty")
        preciosList.add("350")
        imagenes.add("https://indrinks.com.ar/wp-content/uploads/2020/04/Vi%C3%B1a-de-Balbo-2.25L-Pritty-1.5lt.jpg")
        elementos.add("Promo Fernet + coca")
        preciosList.add("1000")
        imagenes.add("https://vinotecalavia.com/4852-large_default/fernet-branca-750cc-1-coca-cola-225lt.jpg")
        elementos.add("Mani saborizado Recancer")
        preciosList.add("600")
        imagenes.add("https://d3ugyf2ht6aenh.cloudfront.net/stores/001/193/620/products/140121-89d95a1e5a7fe6976d16086947883712-1024-1024.jpg")
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