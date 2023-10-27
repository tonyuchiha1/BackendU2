package creational_pattern.abstractfactory

interface IServiceStackAbstractFactory {
    fun getEmployeeService(): IEmployeeService
    fun getProductService(): IProductService

}