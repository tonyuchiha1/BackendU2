package structural_pattern.decorator2

class Spheres (tree: IChristmasTree): TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithSpheres()
    }

    private fun decorateWithSpheres():String{
        return "with Spheres"
    }
}
