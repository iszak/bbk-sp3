import factory._
import org.scalatest.FunSuite

class ConcreteCreatorSuite extends FunSuite {
  test("creates instances of Product") {
    val factory = new ConcreteCreator()

    assert(factory.build().isInstanceOf[Product])
    assert(factory.build().isInstanceOf[ConcreteProduct])
  }

  test("creates new instances of Product") {
    val factory = new ConcreteCreator()

    val product1 = factory.build()
    val product2 = factory.build()

    assert(!product1.eq(product2))
  }
}