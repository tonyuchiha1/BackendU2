package behavior_pattern.nullobject

fun main() {
    // Creamos una instancia del servicio EmployeeDAOService.
    val service = EmployeeDAOService()

    // Buscamos el empleado con ID 1.
    val emp1 = service.findEmployeeById(1L)

    // Imprimimos la dirección completa del empleado 1 si está presente.
    println(emp1.address?.fullAddress)

    // Buscamos el empleado con ID 2.
    val emp2 = service.findEmployeeById(2L)

    // Imprimimos la dirección completa del empleado 2 si está presente.
    println(emp2.address?.fullAddress)
}
