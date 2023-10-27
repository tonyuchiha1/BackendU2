package creational_pattern.objectpool

interface IPoolableObject {
    fun validate (): Boolean
    fun  invalidate()
}