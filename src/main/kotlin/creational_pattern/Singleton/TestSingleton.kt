package creational_pattern.Singleton

fun main (){
    var singletonA: creational_pattern.Singleton.Singleton? = creational_pattern.Singleton.Singleton.getInstance()

    var singletonB: creational_pattern.Singleton.Singleton? = creational_pattern.Singleton.Singleton.getInstance()

    println(singletonA)

    println(singletonB)

    println("Misma referencia ==> " + (singletonA === singletonB))

    singletonA?.setAppName("Singleton Pattern")

    singletonB?.setAppVersion("1.0")

    println("SingletonA ==> $singletonA")

    println("SingletonB ==> $singletonB")

    singletonA = null

    singletonB = null

    singletonA = creational_pattern.Singleton.Singleton.getInstance()

    println("SingletonA ==> $singletonA")
}