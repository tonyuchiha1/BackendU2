package structural_pattern.Composite

fun main(){
    val main = MainComposite()
    main.buildProducts()
    main.orderSimpleProducts()
    main.orderHomePC()
    main.orderGammerPC()
    main.orderCombo()
    main.orderBig()

}