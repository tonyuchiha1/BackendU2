package creational_pattern.Prototype

import kotlin.random.Random

fun main(){
    val standardPriceProducts = PriceList(
        listName = "Standard Price List",
        products = arrayListOf()
    )

    for (c in 1..5) {
        val item = ProductItem( Product(
            name = "Product $c",
            price = Random.nextInt(10,5000).toDouble())
        )
        standardPriceProducts.addProductItem(item)
    }

    //---
    PrototypeFactory.addPrototype(
        standardPriceProducts.listName, standardPriceProducts
    )
    //--- Segunda lista para clientes de mayoreo a partir de la lista
    //--- estándar con un 10% de descuento sobre la lista de precio estándar.
    val wholesalePriceProducts: PriceList =
        PrototypeFactory.getPrototype("Standard Price List") as PriceList
    wholesalePriceProducts.listName= "Wholesale Price List"
    for (item in wholesalePriceProducts.products) {
        item.product.price *= 0.90
    }
    PrototypeFactory.addPrototype(
        wholesalePriceProducts.listName, wholesalePriceProducts
    )
    //--- Tercera lista de precios para clientes VIP a partir de la lista
    //--- de mayoreo con 10% de descuento sobre la lista de precios de mayoreo.
    val vipPriceProducts: PriceList =
        PrototypeFactory.getPrototype("Wholesale Price List") as PriceList
    vipPriceProducts.listName= "VIP Price List"

    for (item in vipPriceProducts.products) {
        item.product.price *= 0.90
    }

    PrototypeFactory.addPrototype(
        vipPriceProducts.listName, vipPriceProducts
    )

    val studentItvoPriceList: PriceList = PrototypeFactory.getPrototype(
        prototypeName = "Standard Price List") as PriceList

    studentItvoPriceList.listName ="Precio a estudiantes ITVO"
    for (item in studentItvoPriceList.products) {
        item.product.price *= 0.70
    }

    println(standardPriceProducts)
    println(wholesalePriceProducts)
    println(vipPriceProducts)
    println(studentItvoPriceList)

}

