package creational_pattern.abstractfactory

import org.json.JSONObject


class ApiRestProducts {
    companion object {
        fun fetchAll(): List<String> {
            val responseHttp = khttp.get(
                url = "http://localhost:8000/api/v1/products"
            )
            val jsonObject: JSONObject = responseHttp.jsonObject
            val data = jsonObject.getJSONArray("data")

            val products = ArrayList<String>()
            for (i in 0 until data.length()) {
                val product = data.getJSONObject(i)
                products.add(product.getString("name"))
            }

            return products.toList()
        }

    }
}