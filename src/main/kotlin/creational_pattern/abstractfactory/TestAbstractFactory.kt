package creational_pattern.abstractfactory

fun main() {
    val factory: IServiceStackAbstractFactory? = ServiceStackAbstractFactory.createServiceFactory()
    val employeeService = factory?.getEmployeeService()
    val productService = factory?.getProductService()
    println("EmployeeService class > " + employeeService?.javaClass?.canonicalName)
    println("ProductService class > " + productService?.javaClass?.canonicalName)
    println("getEmployee > " + employeeService?.getEmployee())
    println("getProduct > " + productService?.getProducts())
}