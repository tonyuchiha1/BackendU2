package creational_pattern.factorymethod

import java.sql.Connection

interface IDBAdapter {
    fun getConnection(): Connection?
}