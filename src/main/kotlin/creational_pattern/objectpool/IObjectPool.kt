package creational_pattern.objectpool

interface IObjectPool<T: IPoolableObject> {
    fun getObject(): T

    fun releaseObject(pooledObject: T)
}
