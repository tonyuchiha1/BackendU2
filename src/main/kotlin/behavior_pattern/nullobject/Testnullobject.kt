package behavior_pattern.nullobject

fun main() {
    val service = EmployeeDAOService()

    val emp1 = service.findEmployeeById(1L)
    println(emp1.address?.fullAddress)

    val emp2 = service.findEmployeeById(2L)
    println(emp2.address?.fullAddress)
}