package mediator

class Valve extends Colleague {
  def open(): Unit = println("Valve is opened...")

  def closed(): Unit = println("Valve is closed...")
}