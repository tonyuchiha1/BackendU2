package creational_pattern.Prototype

interface IPrototype<T> : Cloneable {
    public override fun clone(): Any
    fun deepClone(): T
}