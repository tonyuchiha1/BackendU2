package creational_pattern.Prototype

data class Product(var name: String, var price: Double):
    IPrototype<Product> {
    override fun clone(): Any {
        return Product(name, price)
    }

    override fun deepClone(): Product {
        return  this.clone() as Product
    }
}
