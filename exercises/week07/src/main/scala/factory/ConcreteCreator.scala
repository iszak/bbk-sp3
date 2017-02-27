package factory

class ConcreteCreator extends Creator {
  override def build(): Product = new ConcreteProduct
}
