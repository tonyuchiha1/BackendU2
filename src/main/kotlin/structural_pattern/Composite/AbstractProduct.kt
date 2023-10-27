package structural_pattern.Composite

abstract class AbstractProduct (
    val name:String,
    val tax:Double,
    private val price:Double,
    val quantity: Long){

    open fun getPrice():Double{

        return price*quantity
    }

}

/*
abstract class AbstractProduct (
    val name:String,private val price:Double ){
    open fun getPrice()= price

}

*/