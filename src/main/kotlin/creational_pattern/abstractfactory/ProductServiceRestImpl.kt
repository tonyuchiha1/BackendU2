package creational_pattern.abstractfactory

class ProductServiceRestImpl: IProductService {
  //  private val products = listOf("REST-Teclado", "REST-Mouse", "REST-Monitor")
   override fun getProducts(): List<String> {
      //  return this.products
        //override fun fetchAll(): List<String>{
            return ApiRestProducts.fetchAll()
        }
    }


