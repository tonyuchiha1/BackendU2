package structural_pattern.facade

import structural_pattern.facade.OnMemoryDataBase.findCustomerById

class CRMSystem {
    fun findCustomer(customerId: Long): Customer? {
        return findCustomerById(customerId)
    }
}