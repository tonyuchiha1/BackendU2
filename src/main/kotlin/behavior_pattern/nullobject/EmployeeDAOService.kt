package behavior_pattern.nullobject

class EmployeeDAOService {
    // Lista mutable que almacena instancias de Employee.
    private val EMPLOYEE_LIST: MutableList<Employee> = ArrayList()

    // Bloque de inicialización donde se agrega un empleado a la lista al crear una instancia de la clase.
    init {
        val emp1 = Employee(1L, "Oscar Blancarte", Address("Reforma 150 int 20, México D.F."))
        EMPLOYEE_LIST.add(emp1)
    }

    // Función que busca un empleado por ID en la lista.
    fun findEmployeeById(id: Long): Employee {
        for (emp in EMPLOYEE_LIST) {
            // Comprueba si el ID del empleado coincide con el ID proporcionado.
            if (emp.getId()?.toLong() == id) {
                return emp
            }
        }
        // Si no se encuentra un empleado con el ID proporcionado, devuelve una representación nula.
        return Employee.NULL_EMPLOYEE
    }
}
