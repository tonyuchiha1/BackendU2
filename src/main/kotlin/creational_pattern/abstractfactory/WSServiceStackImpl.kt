package creational_pattern.abstractfactory

class WSServiceStackImpl: IServiceStackAbstractFactory {
    override fun getEmployeeService(): IEmployeeService = EmployeeServiceWSImpl()
    override fun getProductService(): IProductService = ProductServiceWSImpl()
}