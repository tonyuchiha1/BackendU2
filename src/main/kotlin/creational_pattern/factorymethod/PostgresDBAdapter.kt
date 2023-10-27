package creational_pattern.factorymethod

import properties.PropertiesUtil
import java.sql.Connection
import java.sql.DriverManager
import java.util.*

class PostgresDBAdapter : IDBAdapter  {
    private  val  _DB_PROPERTIES = "properties/DBPostgres"
    private  val  _DB_NAME_PROP = "dbname"
    private  val  _DB_HOST_PROP = "host"
    private  val  _DB_PORT_PROP = "port"
    private  val  _DB_PASSWORD_PROP = "password"
    private  val  _DB_USER_PROP = "user"

    override fun getConnection(): Connection? {
        return try {
            Class.forName("org.postgresql.Driver")

            val connectionString = createConnectionString()

            DriverManager.getConnection(connectionString)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun createConnectionString(): String {
        val property: Properties? = PropertiesUtil.loadProperty(_DB_PROPERTIES)
        val host = property!!.getProperty(_DB_HOST_PROP)
        val port = property.getProperty(_DB_PORT_PROP)
        val db = property.getProperty(_DB_NAME_PROP)
        val user = property.getProperty(_DB_USER_PROP)
        val password = property.getProperty(_DB_PASSWORD_PROP)

        return ("jdbc:postgresql://" + host
                + ":" + port + "/" + db + "?user=" + user + "&password=" + password)

    }

}