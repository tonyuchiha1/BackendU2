package structural_pattern.decorator2

class Star (tree: IChristmasTree): TreeDecorator(tree){
    override fun decorate(): String {
        return super.decorate() + decorateWithStar()
    }

    private fun decorateWithStar():String{
        return "with Spheres"
    }
}
