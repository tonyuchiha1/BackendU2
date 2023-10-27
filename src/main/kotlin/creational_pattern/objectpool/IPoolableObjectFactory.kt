package creational_pattern.objectpool

interface IPoolableObjectFactory<T : IPoolableObject?> {
    fun createNew(): T
}
