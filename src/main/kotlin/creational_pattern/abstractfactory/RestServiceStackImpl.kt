package creational_pattern.abstractfactory

class RestServiceStackImpl: IServiceStackAbstractFactory {
    override fun getProductService(): IProductService = ProductServiceRestImpl()
    override fun getEmployeeService(): IEmployeeService= EmployeeServiceRestImpl()
}