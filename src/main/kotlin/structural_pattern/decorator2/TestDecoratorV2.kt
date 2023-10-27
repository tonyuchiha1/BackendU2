package structural_pattern.decorator2

fun main(){
    val pine= PineChristmasTree()
    val christmasTree = BubbleLights(pine)
    val decorateChristmasTree= Spheres(christmasTree)

    val decorated = Star(BubbleLights(Spheres(PineChristmasTree())))

    println(decorateChristmasTree.decorate())
    println(decorated.decorate())
}