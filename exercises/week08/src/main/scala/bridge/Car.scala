package bridge

abstract class Car(product: Product, carType: String) {

  def assemble = {
    println(s"Modifying product ${product.productName} according to $carType")
    println(s"Assembling ${product.productName} for $carType")
  }

  def produceProduct = product.produce

  def printDetails = println(s"Car: $carType, Product:${product.productName}")
}
