package behavior_pattern.nullobject

class EmployeeDAOService {
    private val EMPLOYEE_LIST: MutableList<Employee> = ArrayList()

    init {
        val emp1 = Employee(1L, "Oscar Blancarte", Address("Reforma 150 int 20, México D.F."))
        EMPLOYEE_LIST.add(emp1)
    }

    fun findEmployeeById(id: Long): Employee {
        for (emp in EMPLOYEE_LIST) {
            if (emp.getId()?.toLong() == id) {
                return emp
            }
        }
        return Employee.NULL_EMPLOYEE
    }
}
