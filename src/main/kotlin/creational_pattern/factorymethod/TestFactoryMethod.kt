package creational_pattern.factorymethod

fun main(){
    val productDAO= ProductDAO()
    val products = productDAO.findAllProducts()

    println("before save")

    products!!.forEach {  println(it.toString()) }

    //--- insert new product
    print("Introduzca el producto: ")

    val name = readln()
    print ("Introduzca el precio: ")
    val price =  readln().toDouble()

    val product= Product(id=0, name = name,price= price)
    productDAO.saveProduct(product)
    println("-------------------------------------")
    println(" ${product.name},  ${product.price}" )

}


