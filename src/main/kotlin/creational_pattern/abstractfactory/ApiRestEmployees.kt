package creational_pattern.abstractfactory
import org.json.JSONObject


class ApiRestEmployees {
    companion object {

        fun fetchAll(): List<String> {
            val responseHttp = khttp.get(
                url = "http://localhost:8000/api/v1/employees"
            )
            val jsonObject: JSONObject = responseHttp.jsonObject
            val data = jsonObject.getJSONArray("data")

            val employees = ArrayList<String>()
            for (i in 0 until data.length()) {
                val employee = data.getJSONObject(i)
                employees.add(employee.getString("fullname"))
            }

            return employees.toList()
        }
    }
}
